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

/**
 * Base class for {@link CharacterPartAttacher} implementations that can be skipped in the attaching process.
 * <p>
 * Skippable attachers are used for parts that are not required to be attached to a character, such as eyeglasses, hats
 * or sleeves.
 * <p>
 * Subclasses should override the {@link #shouldAttach(AttachedPart, Anchor, CharacterBuilderContext)} method to specify
 * whether the part should be attached or not.
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


    /**
     * Attaches the part to the destination part at the specified anchor in the given context. If the part should not be
     * attached according to the result of {@link #shouldAttach(AttachedPart, Anchor, CharacterBuilderContext)}, this
     * method does nothing.
     *
     * @param destinationPart the destination part
     * @param anchor          the anchor
     * @param context         the context
     */
    @Override
    public void attach(AttachedPart<DP> destinationPart, Anchor anchor, CharacterBuilderContext context) {
        if (!shouldAttach(destinationPart, anchor, context)) {
            logger.debug(
                "{}: skipping attaching part to destinationPart={}, anchor={}",
                getClass().getSimpleName(),
                destinationPart,
                anchor
            );
            return;
        }

        super.attach(destinationPart, anchor, context);
    }

    protected abstract boolean shouldAttach(
        AttachedPart<DP> destinationPart,
        Anchor anchor,
        CharacterBuilderContext context
    );
}
