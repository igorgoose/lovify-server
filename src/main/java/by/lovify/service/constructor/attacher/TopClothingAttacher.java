package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Body;
import by.lovify.model.constructor.part.TopClothing;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopClothingAttacher extends CharacterPartAttacher<TopClothing, Body> {

    public TopClothingAttacher(
        CharacterPartBuilder<TopClothing> sourcePartBuilder,
        List<CharacterPartAttacher<?, TopClothing>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return "connect-clothing-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-clothing";
    }

    @Override
    protected String getDestinationGroupId() {
        return "top-clothing-group";
    }
}
