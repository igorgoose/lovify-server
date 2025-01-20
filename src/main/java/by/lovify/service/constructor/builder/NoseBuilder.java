package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.Nose;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
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
