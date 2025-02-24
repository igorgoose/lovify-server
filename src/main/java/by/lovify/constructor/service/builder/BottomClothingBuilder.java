package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.part.BottomClothing;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.util.Optional;

@Component
public class BottomClothingBuilder extends CharacterPartBuilder<BottomClothing> {

    public BottomClothingBuilder(SvgDocumentLoader svgDocumentLoader) {
        super(svgDocumentLoader, CharacterVisualConfig::bottomClothing);
    }

    @Override
    public BottomClothing wrap(SVGSVGElement svgsvgElement, Optional<BottomClothing> ownerPart) {
        return new BottomClothing(svgsvgElement);
    }

}
