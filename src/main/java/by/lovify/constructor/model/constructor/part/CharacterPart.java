package by.lovify.constructor.model.constructor.part;

import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.Optional;

/**
 * A part of the character that can be built and transformed.
 * <p>
 * Provides the SVG representation of the part and the initial transformation of the part.
 * The initial transformation might be obtained by the part during part's build process.
 */
public interface CharacterPart {

    SVGSVGElement svg();

    default Optional<AffineTransform> initialTransform() {
        return Optional.empty();
    }
}
