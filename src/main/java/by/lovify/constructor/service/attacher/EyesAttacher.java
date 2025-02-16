package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.model.constructor.part.Eyes;
import by.lovify.constructor.model.constructor.part.Face;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class EyesAttacher extends CharacterPartAttacher<Eyes, Face> {

    public EyesAttacher(
        CharacterPartBuilder<Eyes> sourcePartBuilder,
        List<CharacterPartAttacher<?, Eyes>> attachers,
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
        return CharacterBuilderConstants.EYES_GROUP;
    }
}
