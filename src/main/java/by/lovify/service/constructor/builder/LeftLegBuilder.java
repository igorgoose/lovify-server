package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.LeftLeg;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import by.lovify.util.CharacterBuilderUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.Optional;

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
