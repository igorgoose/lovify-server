package by.lovify.service.constructor.builder;


import static by.lovify.util.XPathUtils.initXPathExpression;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.CustomizationConfig;
import by.lovify.model.constructor.CharacterBuilderContext;
import by.lovify.model.constructor.part.CharacterPart;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGAnimatedRect;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;
import java.util.function.Function;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

@Slf4j
@RequiredArgsConstructor
public abstract class CharacterPartBuilder<T extends CharacterPart> {

    private static final XPathExpression SKIN_COLOR_ELEMENT_X_PATH =
        initXPathExpression("//*[@class=\"color-face\"]|//*[@id=\"color-face\"]");

    private final SvgDocumentLoader svgDocumentLoader;
    private final Function<CharacterVisualConfig, CustomizationConfig> customizationConfigExtractor;

    public T build(CharacterBuilderContext context) {
        logger.debug("{}: building character part", getClass().getSimpleName());

        CharacterVisualConfig visualConfig = context.getVisualConfig();
        SVGDocument svgDocument = svgDocumentLoader.load(customizationConfigExtractor.apply(visualConfig));

        setDefaultSvgPosition(svgDocument.getRootElement());
        adjustSkinColor(svgDocument, visualConfig);

        return createPart(svgDocument);
    }

    public abstract T wrap(SVGSVGElement svgsvgElement, Optional<T> ownerPart);

    protected T createPart(SVGDocument svgDocument) {
        return wrap(svgDocument.getRootElement(), Optional.empty());
    }

    private void setDefaultSvgPosition(SVGSVGElement svgElement) {
        svgElement.setAttribute("x", "0");
        svgElement.setAttribute("y", "0");
        SVGAnimatedRect viewBox = svgElement.getViewBox();
        svgElement.setAttribute("width", String.valueOf(viewBox.getBaseVal().getWidth()));
        svgElement.setAttribute("height", String.valueOf(viewBox.getBaseVal().getHeight()));
    }

    private void adjustSkinColor(SVGDocument svgDocument, CharacterVisualConfig visualConfig) {
        try {
            NodeList nodeList = (NodeList) SKIN_COLOR_ELEMENT_X_PATH.evaluate(svgDocument, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i) instanceof Element element) {
                    element.setAttribute("fill", visualConfig.skinColor());
                }
            }
        } catch (XPathExpressionException e) {
            // todo better handling
            throw new RuntimeException(e);
        }
    }
}
