package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.model.constructor.part.Mouth;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class MouthAttacher extends CharacterPartAttacher<Mouth, Face> {

    public MouthAttacher(
        CharacterPartBuilder<Mouth> sourcePartBuilder,
        List<CharacterPartAttacher<?, Mouth>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return CharacterBuilderConstants.MOUTH_ANCHOR;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.MOUTH_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.MOUTH_GROUP;
    }
}
