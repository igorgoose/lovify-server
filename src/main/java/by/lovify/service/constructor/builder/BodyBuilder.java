package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.Body;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
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
