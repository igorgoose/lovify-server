package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.Eyebrows;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class EyebrowsAttacher extends CharacterPartAttacher<Eyebrows, Face> {

    public EyebrowsAttacher(
        CharacterPartBuilder<Eyebrows> sourcePartBuilder,
        List<CharacterPartAttacher<?, Eyebrows>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return CharacterBuilderConstants.EYES_ANCHOR;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.EYES_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.EYEBROWS_GROUP;
    }
}
