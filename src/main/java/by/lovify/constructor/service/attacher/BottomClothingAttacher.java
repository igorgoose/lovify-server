package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.model.constructor.part.Body;
import by.lovify.constructor.model.constructor.part.BottomClothing;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BottomClothingAttacher extends CharacterPartAttacher<BottomClothing, Body>{

    public BottomClothingAttacher(
        CharacterPartBuilder<BottomClothing> partBuilder,
        List<CharacterPartAttacher<?, BottomClothing>> characterPartAttachers,
        CharacterPartPositioner characterPartPositioner,
        ConnectorResolver connectorResolver
    ) {
        super(partBuilder, characterPartAttachers, characterPartPositioner, connectorResolver);
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
        return CharacterBuilderConstants.BOTTOM_CLOTHING_GROUP;
    }
}
