package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.model.constructor.part.Mustache;
import by.lovify.constructor.service.attacher.connector.MustacheConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MustacheAttacher extends CharacterPartAttacher<Mustache, Face> {

    public MustacheAttacher(
        CharacterPartBuilder<Mustache> partBuilder,
        List<CharacterPartAttacher<?, Mustache>> characterPartAttachers,
        CharacterPartPositioner characterPartPositioner,
        MustacheConnectorResolver connectorResolver
    ) {
        super(partBuilder, characterPartAttachers, characterPartPositioner, connectorResolver);
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
        return CharacterBuilderConstants.MUSTACHE_GROUP;
    }
}
