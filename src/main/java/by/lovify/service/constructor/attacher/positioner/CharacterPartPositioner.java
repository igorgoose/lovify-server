package by.lovify.service.constructor.attacher.positioner;

import by.lovify.model.constructor.Anchor;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGSVGElement;

public interface CharacterPartPositioner {

    void positionElement(Element elementForPositioning, Context positioningContext);

    record Context(
        SVGSVGElement destinationSvg,
        Anchor anchor
    ) {

    }

}
