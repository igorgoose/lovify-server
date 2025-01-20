package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.TopClothing;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
public class TopClothingBuilder extends CharacterPartBuilder<TopClothing> {

    public TopClothingBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::topClothing);
    }

    @Override
    public TopClothing wrap(SVGSVGElement svgsvgElement, Optional<TopClothing> ownerPart) {
        return new TopClothing(svgsvgElement);
    }

}
