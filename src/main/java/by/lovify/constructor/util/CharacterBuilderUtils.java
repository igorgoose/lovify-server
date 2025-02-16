package by.lovify.constructor.util;

import static javax.xml.xpath.XPathConstants.NODE;
import static javax.xml.xpath.XPathConstants.NODESET;

import by.lovify.constructor.model.constructor.Anchor;
import by.lovify.constructor.model.constructor.AttachedPart;
import by.lovify.constructor.model.constructor.OpenSvgTransform;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.batik.anim.dom.SVGOMGElement;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGCircleElement;
import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

@Slf4j
@UtilityClass
public class CharacterBuilderUtils {

    private static final XPathExpression ANCHOR_NODES_XPATH_EXPR =
        XPathUtils.initXPathExpression(
            "./*[name() = 'circle' and contains(@id, '-grip')] | ./*[name() = 'circle' and contains(@id, '-anchor')]"
        );
    private static final String GROUP_BY_ID_EXPR_TEMPLATE = "//*[@id='%s' and name() = 'g']";


    public static List<Anchor> findAnchors(AttachedPart<?> attachedPart) {
        List<Node> anchorNodes = findAnchorNodes(attachedPart.part().svg());

        return anchorNodes.stream()
            .map(node -> toAnchor(node, attachedPart.transform()))
            .toList();
    }

    public static List<Node> findAnchorNodes(SVGSVGElement svgElement) {
        try {
            NodeList nodeList = (NodeList) ANCHOR_NODES_XPATH_EXPR.evaluate(svgElement, NODESET);
            if (nodeList.getLength() == 0) {
                return List.of();
            }

            List<Node> nodes = new ArrayList<>(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                nodes.add(nodeList.item(i));
            }
            return nodes;
        } catch (XPathExpressionException e) {
            // todo revisit this
            throw new RuntimeException(e);
        }
    }

    public static Optional<SVGOMGElement> findGroupById(SVGSVGElement svgElement, String id) {
        try {
            String expression = String.format(GROUP_BY_ID_EXPR_TEMPLATE, id);
            XPathExpression xPathExpression = XPathUtils.initXPathExpression(expression);
            return Optional.ofNullable((SVGOMGElement) xPathExpression.evaluate(svgElement, NODE));
        } catch (XPathExpressionException e) {
            // todo maybe better handling
            throw new IllegalStateException(e);
        }
    }

    public static double calculateOriginalSize(float newSize, AffineTransform parentTransform) {
        Point2D newZero = new Point2D.Float(0, 0);
        Point2D newRadius = new Point2D.Float(0, newSize);

        Point2D originalZero = parentTransform.transform(newZero, newZero);
        Point2D originalRadius = parentTransform.transform(newRadius, newRadius);

        return originalRadius.distance(originalZero);
    }

    public static AffineTransform reflectByX(SVGSVGElement svgElement) {
        Document document = svgElement.getOwnerDocument();
        SVGOMGElement g = (SVGOMGElement) document.createElementNS(SVGConstants.SVG_NAMESPACE_URI, "g");

        OpenSvgTransform translate = new OpenSvgTransform();
        float w = svgElement.getViewBox().getBaseVal().getWidth(); // assuming x = 0
        translate.setTranslate(w, 0);

        OpenSvgTransform scale = new OpenSvgTransform();
        scale.setScale(-1f, 1f);

        List<OpenSvgTransform> transforms = List.of(translate, scale);
        AffineTransform combinedTransform = calculateNewAffineTransform(new AffineTransform(), transforms);
        transforms.forEach(it -> g.getTransform().getBaseVal().appendItem(it));

        NodeList childNodes = svgElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                g.appendChild(childNodes.item(i));
            }
        }

        while (svgElement.hasChildNodes()) {
            svgElement.removeChild(svgElement.getFirstChild());
        }

        svgElement.appendChild(g);
        return combinedTransform;
    }


    public static AffineTransform calculateNewAffineTransform(
        AffineTransform parentTransform,
        List<OpenSvgTransform> transforms
    ) {
        AffineTransform parentTransformCopy = new AffineTransform(parentTransform);

        return transforms.stream().reduce(
            parentTransformCopy,
            (acc, transform) -> {
                acc.concatenate(transform.getAffineTransform());
                return acc;
            },
            (transform1, transform2) -> {
                transform1.concatenate(transform2);
                return transform1;
            }
        );
    }

    private static Anchor toAnchor(Node anchorNode, AffineTransform parentTransform) {
        SVGCircleElement circleElement = (SVGCircleElement) anchorNode;
        float x = circleElement.getCx().getBaseVal().getValue();
        float y = circleElement.getCy().getBaseVal().getValue();
        float size = circleElement.getR().getBaseVal().getValue();

        Point2D original = parentTransform.transform(new Float(x, y), null);

        return new Anchor(
            circleElement.getId(),
            original,
            size,
            circleElement
        );
    }
}
