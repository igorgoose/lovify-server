package by.lovify.service.constructor;


import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.AttachedPart;
import by.lovify.model.constructor.CharacterBuilderContext;
import by.lovify.service.constructor.builder.InitialPartBuilder;
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
