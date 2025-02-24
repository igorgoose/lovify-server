package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.Background;
import by.lovify.constructor.model.constructor.part.FrontHair;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class FrontHairAttacher extends CharacterPartAttacher<FrontHair, Background> {

    public FrontHairAttacher(
        CharacterPartBuilder<FrontHair> sourcePartBuilder,
        List<CharacterPartAttacher<?, FrontHair>> attachers,
        CharacterPartPositioner characterPartPositioner,
        ConnectorResolver connectorResolver
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner, connectorResolver);
    }

    @Override
    public String getAnchorId() {
        return CharacterBuilderConstants.HAIR_GRIP;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.HAIR_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.FRONT_HAIR_GROUP;
    }
}
