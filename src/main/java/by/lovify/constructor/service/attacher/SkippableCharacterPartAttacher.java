package by.lovify.constructor.service.attacher;

import by.lovify.constructor.model.constructor.Anchor;
import by.lovify.constructor.model.constructor.AttachedPart;
import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.part.CharacterPart;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * Base class for {@link CharacterPartAttacher} implementations that can be skipped in the attaching process.
 * <p>
 * Skippable attachers are used for parts that are not required to be attached to a character, such as eyeglasses, hats
 * or sleeves.
 * <p>
 * Subclasses should override the {@link #shouldAttach(P, AttachedPart, Anchor, CharacterBuilderContext)} method to
 * specify whether the part should be attached or not.
 */
@Slf4j
public abstract class SkippableCharacterPartAttacher<P extends CharacterPart, DP extends CharacterPart>
    extends CharacterPartAttacher<P, DP> {

    public SkippableCharacterPartAttacher(
        CharacterPartBuilder<P> partBuilder,
        List<CharacterPartAttacher<?, P>> characterPartAttachers,
        CharacterPartPositioner characterPartPositioner,
        ConnectorResolver connectorResolver
    ) {
        super(partBuilder, characterPartAttachers, characterPartPositioner, connectorResolver);
    }

    @Override
    public void attach(AttachedPart<DP> destinationPart, Anchor anchor, CharacterBuilderContext context) {
        // calculate absolute position of connector element in destination part's coordinate system
        // calculate difference between that and anchor's position
        // insert part into destination part and apply transformations
        logger.debug(
            "{}: attaching part to destinationPart={}, anchor={}",
            getClass().getSimpleName(),
            destinationPart,
            anchor
        );

        P part = partBuilder.build(context);
        Optional<AttachedPart<P>> attachedPartOptional = doAttachIfShould(part, destinationPart, anchor, context);
        attachedPartOptional.ifPresent(it -> {
            context.registerAttachers(it, attachers);
            context.onPartAttached(it);
        });
    }

    /**
     * Invokes {@link #doAttach(CharacterPart, AttachedPart, Anchor, CharacterBuilderContext)} if the implementation of
     * {@link #shouldAttach(CharacterPart, AttachedPart, Anchor, CharacterBuilderContext)} returns true.
     * <p>
     * If the implementation of {@link #shouldAttach(CharacterPart, AttachedPart, Anchor, CharacterBuilderContext)}
     * returns false, logs a debug message and returns an empty optional.
     *
     * @param part            the part to attach
     * @param destinationPart the part to attach to
     * @param anchor          the anchor to align with
     * @param context         the context of the character builder
     * @return an optional containing the attached part if the part should be attached, empty otherwise
     */
    protected Optional<AttachedPart<P>> doAttachIfShould(
        P part,
        AttachedPart<DP> destinationPart,
        Anchor anchor,
        CharacterBuilderContext context
    ) {
        if (!shouldAttach(part, destinationPart, anchor, context)) {
            logger.debug(
                "{}: skipping attaching part to destinationPart={}, anchor={}",
                getClass().getSimpleName(),
                destinationPart,
                anchor
            );
            return Optional.empty();
        }

        return Optional.of(super.doAttach(part, destinationPart, anchor, context));
    }

    protected abstract boolean shouldAttach(
        P part,
        AttachedPart<DP> destinationPart,
        Anchor anchor,
        CharacterBuilderContext context
    );
}
