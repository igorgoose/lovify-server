package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.RightLeg;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
public class RightLegBuilder extends CharacterPartBuilder<RightLeg> {

    public RightLegBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::rightLeg);
    }

    @Override
    public RightLeg wrap(SVGSVGElement svgsvgElement, Optional<RightLeg> ownerPart) {
        return new RightLeg(svgsvgElement);
    }
}
