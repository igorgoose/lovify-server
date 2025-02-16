package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Body;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
public class BodyBuilder extends CharacterPartBuilder<Body> {

    public BodyBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::bodyType);
    }

    @Override
    public Body wrap(SVGSVGElement svgsvgElement, Optional<Body> ownerPart) {
        return new Body(svgsvgElement);
    }

}
