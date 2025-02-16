package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.RightLeg;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
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
