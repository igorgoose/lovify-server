package by.lovify.service.constructor.attacher.positioner;

import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
public class AtBottomLayerPositioner implements CharacterPartPositioner {

    @Override
    public void positionElement(Element elementForPositioning, Context positioningContext) {
        NodeList childNodes = positioningContext.destinationSvg().getChildNodes();

        if (childNodes.getLength() == 0) {
            positioningContext.destinationSvg().appendChild(elementForPositioning);
            return;
        }

        Node firstNode = childNodes.item(0);
        positioningContext.destinationSvg().insertBefore(elementForPositioning, firstNode);
    }
}
