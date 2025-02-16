package by.lovify.constructor.model.constructor.part;

import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.util.Optional;

public record LeftLeg(SVGSVGElement svg, AffineTransform reflectTransform) implements CharacterPart {

    @Override
    public Optional<AffineTransform> initialTransform() {
        return Optional.of(reflectTransform);
    }
}
