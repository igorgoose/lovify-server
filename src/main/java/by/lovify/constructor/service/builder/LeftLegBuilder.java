package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.LeftLeg;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import by.lovify.constructor.util.CharacterBuilderUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.Optional;

/**
 * Builder for the left leg character part.
 * <p>
 * The left leg is special, because it has a reflected transform which is applied to the SVG containing right leg.
 */
@Component
public class LeftLegBuilder extends CharacterPartBuilder<LeftLeg> {

    public LeftLegBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::leftLeg);
    }

    @Override
    public LeftLeg wrap(SVGSVGElement svgsvgElement, Optional<LeftLeg> ownerPart) {
        if (ownerPart.isEmpty()) {
            throw new IllegalArgumentException("Owner part must not be empty for left leg");
        }
        return new LeftLeg(svgsvgElement, ownerPart.get().reflectTransform());
    }

    @Override
    protected LeftLeg createPart(SVGDocument svgDocument) {
        AffineTransform reflectTransform = CharacterBuilderUtils.reflectByX(svgDocument.getRootElement());
        return new LeftLeg(svgDocument.getRootElement(), reflectTransform);
    }
}
