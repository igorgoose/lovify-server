package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.Eyebrows;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
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
