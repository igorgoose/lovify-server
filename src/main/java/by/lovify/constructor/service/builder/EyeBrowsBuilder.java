package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.Eyebrows;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
class EyeBrowsBuilder extends CharacterPartBuilder<Eyebrows> {

    public EyeBrowsBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::eyebrows);
    }

    @Override
    public Eyebrows wrap(SVGSVGElement svgsvgElement, Optional<Eyebrows> ownerPart) {
        return new Eyebrows(svgsvgElement);
    }
}
