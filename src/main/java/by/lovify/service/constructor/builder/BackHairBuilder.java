package by.lovify.service.constructor.builder;

import static by.lovify.util.XPathUtils.initXPathExpression;
import static javax.xml.xpath.XPathConstants.NODESET;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.BackHair;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

@Component
class BackHairBuilder extends CharacterPartBuilder<BackHair> {

    private static final XPathExpression NOT_BACK_HAIR_X_PATH =
        initXPathExpression("./*[not(contains(@class, \"back-hair\"))]");

    public BackHairBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::hair);
    }

    @Override
    public BackHair wrap(SVGSVGElement svgsvgElement, Optional<BackHair> ownerPart) {
        return new BackHair(svgsvgElement);
    }

    @Override
    protected BackHair createPart(SVGDocument svgDocument) {
        try {
            SVGSVGElement svgElement = svgDocument.getRootElement();
            NodeList redundantNodeList = (NodeList) NOT_BACK_HAIR_X_PATH.evaluate(svgElement, NODESET);

            for (int i = 0; i < redundantNodeList.getLength(); i++) {
                svgElement.removeChild(redundantNodeList.item(i));
            }

            return new BackHair(svgElement);
        } catch (XPathExpressionException e) {
            // todo better handling
            throw new RuntimeException(e);
        }
    }
}
