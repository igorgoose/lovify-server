package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.Background;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FaceAttacher extends CharacterPartAttacher<Face, Background> {

    public FaceAttacher(
        CharacterPartBuilder<Face> sourcePartBuilder,
        List<CharacterPartAttacher<?, Face>> attachers,
        CharacterPartPositioner characterPartPositioner,
        ConnectorResolver connectorResolver
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner, connectorResolver);
    }

    @Override
    public String getAnchorId() {
        return CharacterBuilderConstants.FACE_GRIP;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.FACE_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.FACE_GROUP;
    }
}
