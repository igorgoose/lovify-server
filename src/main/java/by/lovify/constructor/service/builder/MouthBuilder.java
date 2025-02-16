package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Mouth;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
class MouthBuilder extends CharacterPartBuilder<Mouth> {

    public MouthBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::mouth);
    }

    @Override
    public Mouth wrap(SVGSVGElement svgsvgElement, Optional<Mouth> ownerPart) {
        return new Mouth(svgsvgElement);
    }
}
