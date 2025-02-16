package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.Body;
import by.lovify.constructor.model.constructor.part.TopClothing;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
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
        return CharacterBuilderConstants.CLOTHING_ANCHOR;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.CLOTHING_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.TOP_CLOTHING_GROUP;
    }
}
