package by.lovify.constructor.service.attacher.positioner;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

@Primary
@Component
public class BeforeAnchorElementPositioner implements CharacterPartPositioner {

    @Override
    public void positionElement(Element elementForPositioning, Context positioningContext) {
        positioningContext.destinationSvg().insertBefore(elementForPositioning, positioningContext.anchor().element());
    }
}
