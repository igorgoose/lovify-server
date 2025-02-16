package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Nose;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
class NoseBuilder extends CharacterPartBuilder<Nose> {

    public NoseBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::nose);
    }

    @Override
    public Nose wrap(SVGSVGElement svgsvgElement, Optional<Nose> ownerPart) {
        return new Nose(svgsvgElement);
    }
}
