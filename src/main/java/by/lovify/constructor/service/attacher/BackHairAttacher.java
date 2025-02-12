package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.BackHair;
import by.lovify.constructor.model.constructor.part.Background;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class BackHairAttacher extends CharacterPartAttacher<BackHair, Background> {

    public BackHairAttacher(
        CharacterPartBuilder<BackHair> sourcePartBuilder,
        List<CharacterPartAttacher<?, BackHair>> attachers,
        @Qualifier("atBottomLayerPositioner") CharacterPartPositioner characterPartPositioner,
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
        return CharacterBuilderConstants.BACK_HAIR_GROUP;
    }
}
