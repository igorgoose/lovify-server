package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Mustache;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
public class MustacheBuilder extends CharacterPartBuilder<Mustache> {

    public MustacheBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::mustache);
    }

    @Override
    public Mustache wrap(SVGSVGElement svgsvgElement, Optional<Mustache> ownerPart) {
        return new Mustache(svgsvgElement);
    }
}
