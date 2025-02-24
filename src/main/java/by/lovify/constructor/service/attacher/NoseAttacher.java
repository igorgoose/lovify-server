package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.model.constructor.part.Nose;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class NoseAttacher extends CharacterPartAttacher<Nose, Face> {

    public NoseAttacher(
        CharacterPartBuilder<Nose> sourcePartBuilder,
        List<CharacterPartAttacher<?, Nose>> attachers,
        CharacterPartPositioner characterPartPositioner,
        ConnectorResolver connectorResolver
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner, connectorResolver);
    }

    @Override
    public String getAnchorId() {
        return CharacterBuilderConstants.NOSE_ANCHOR;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.NOSE_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.NOSE_GROUP;
    }
}
