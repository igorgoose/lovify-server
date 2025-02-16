package by.lovify.constructor.service;


import by.lovify.constructor.service.builder.InitialPartBuilder;
import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.constructor.AttachedPart;
import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

@RequiredArgsConstructor
@Service
public class CharacterSvgService {

    private final InitialPartBuilder initPartBuilder;

    public SVGDocument build(CharacterVisualConfig visualConfig) {
        CharacterBuilderContext context = new CharacterBuilderContext(visualConfig);
        AttachedPart<?> initialPart = initPartBuilder.buildInitialPart(context);
        SVGSVGElement svg = initialPart.part().svg();

        return (SVGDocument) svg.getOwnerDocument();
    }
}
