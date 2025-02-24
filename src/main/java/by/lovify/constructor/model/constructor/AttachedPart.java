package by.lovify.constructor.model.constructor;

import by.lovify.constructor.model.constructor.part.CharacterPart;

import java.awt.geom.AffineTransform;

/**
 * Represents an attached part of a character with its associated transformation. The transformation is stored for
 * calculation of coordinates of a part being attached in the SVG's original coordinate system during attachment.
 *
 * @param <T> the type of the character part, extending {@link CharacterPart}
 */
public record AttachedPart<T extends CharacterPart>(T part, AffineTransform transform) {

    public AttachedPart(T part, AffineTransform transform) {
        this.part = part;
        this.transform = part.initialTransform()
            .map(it -> {
                AffineTransform transformCopy = new AffineTransform(transform);
                transformCopy.concatenate(it);
                return transformCopy;
            })
            .orElse(transform);
    }
}
