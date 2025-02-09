package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.Mouth;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
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
