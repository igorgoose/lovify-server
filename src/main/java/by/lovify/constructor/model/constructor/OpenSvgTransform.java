package by.lovify.constructor.model.constructor;

import org.apache.batik.dom.svg.SVGOMTransform;

import java.awt.geom.AffineTransform;

/**
 * {@link SVGOMTransform} with access to {@link SVGOMTransform#affineTransform} for calculations of combined transforms
 */
public class OpenSvgTransform extends SVGOMTransform {

    public AffineTransform getAffineTransform() {
        return affineTransform;
    }
}
