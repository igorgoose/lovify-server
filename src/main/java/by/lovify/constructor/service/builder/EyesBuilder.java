package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Eyes;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
class EyesBuilder extends CharacterPartBuilder<Eyes> {

    public EyesBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::eyes);
    }

    @Override
    public Eyes wrap(SVGSVGElement svgsvgElement, Optional<Eyes> ownerPart) {
        return new Eyes(svgsvgElement);
    }
}
