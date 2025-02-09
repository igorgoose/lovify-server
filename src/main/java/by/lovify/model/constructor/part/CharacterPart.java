package by.lovify.model.constructor.part;

import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.Optional;

public interface CharacterPart {

    SVGSVGElement svg();

    default Optional<AffineTransform> initialTransform() {
        return Optional.empty();
    }
}
