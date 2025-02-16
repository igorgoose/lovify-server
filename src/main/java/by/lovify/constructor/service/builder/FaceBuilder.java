package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
class FaceBuilder extends CharacterPartBuilder<Face> {

    public FaceBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::faceType);
    }

    @Override
    public Face wrap(SVGSVGElement svgsvgElement, Optional<Face> ownerPart) {
        return new Face(svgsvgElement);
    }
}
