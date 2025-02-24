package by.lovify.constructor.model.constructor.part;

import by.lovify.constructor.service.builder.LeftLegBuilder;
import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.Optional;

/**
 * Left leg of the character.
 *
 * <p>This class is a part of character model and represents left leg.
 * It has a {@link SVGSVGElement} which contains SVG data of the leg and a matrix that represents a reflection of the
 * leg, which is applied to right leg to get the left leg (@see {@link LeftLegBuilder}). This matrix is used to draw the
 * leg on the left side of the character.
 */
public record LeftLeg(SVGSVGElement svg, AffineTransform reflectTransform) implements CharacterPart {

    @Override
    public Optional<AffineTransform> initialTransform() {
        return Optional.of(reflectTransform);
    }
}
