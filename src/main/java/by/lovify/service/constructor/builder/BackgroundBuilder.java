package by.lovify.service.constructor.builder;

import by.lovify.model.CustomizationConfig;
import by.lovify.model.constructor.AttachedPart;
import by.lovify.model.constructor.CharacterBuilderContext;
import by.lovify.model.constructor.part.Background;
import by.lovify.properties.CharacterPreviewProperties;
import by.lovify.service.constructor.attacher.CharacterPartAttacher;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.Optional;

@Component
public class BackgroundBuilder extends CharacterPartBuilder<Background> implements InitialPartBuilder {

    private final List<CharacterPartAttacher<?, Background>> attachers;

    public BackgroundBuilder(
        SvgDocumentLoader svgDocumentLoader,
        CharacterPreviewProperties properties,
        List<CharacterPartAttacher<?, Background>> attachers
    ) {
        super(
            svgDocumentLoader,
            ignored -> new CustomizationConfig().setId(properties.backgroundId())
        );
        this.attachers = attachers;
    }

    @Override
    public AttachedPart<Background> buildInitialPart(CharacterBuilderContext context) {
        Background background = build(context);
        AttachedPart<Background> attachedBackground = new AttachedPart<>(background, new AffineTransform());
        context.registerAttachers(attachedBackground, attachers);
        context.onPartAttached(attachedBackground);
        return attachedBackground;
    }

    @Override
    public Background wrap(SVGSVGElement svgsvgElement, Optional<Background> ownerPart) {
        return new Background(svgsvgElement);
    }
}
