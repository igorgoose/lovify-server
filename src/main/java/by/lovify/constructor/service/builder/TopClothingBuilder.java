package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.TopClothing;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
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
