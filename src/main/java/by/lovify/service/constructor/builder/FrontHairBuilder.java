package by.lovify.service.constructor.builder;

import static by.lovify.util.XPathUtils.initXPathExpression;
import static javax.xml.xpath.XPathConstants.NODESET;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.FrontHair;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

@Component
class FrontHairBuilder extends CharacterPartBuilder<FrontHair> {

    private static final XPathExpression NOT_FRONT_HAIR_X_PATH =
        initXPathExpression("./*[not(contains(@class, \"front-hair\"))]");

    public FrontHairBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::hair);
    }

    @Override
    public FrontHair wrap(SVGSVGElement svgsvgElement, Optional<FrontHair> ownerPart) {
        return new FrontHair(svgsvgElement);
    }

    @Override
    protected FrontHair createPart(SVGDocument svgDocument) {
        try {
            SVGSVGElement svgElement = svgDocument.getRootElement();
            NodeList redundantNodeList = (NodeList) NOT_FRONT_HAIR_X_PATH.evaluate(svgElement, NODESET);

            for (int i = 0; i < redundantNodeList.getLength(); i++) {
                svgElement.removeChild(redundantNodeList.item(i));
            }

            return new FrontHair(svgElement);
        } catch (XPathExpressionException e) {
            // todo better handling
            throw new RuntimeException(e);
        }
    }
}
