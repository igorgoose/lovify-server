package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.Eyes;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
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
