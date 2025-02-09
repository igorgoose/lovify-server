package by.lovify.model.constructor;

import by.lovify.model.constructor.part.CharacterPart;

import java.awt.geom.AffineTransform;

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
