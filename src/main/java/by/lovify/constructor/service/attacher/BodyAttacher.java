package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.model.constructor.part.Background;
import by.lovify.constructor.model.constructor.part.Body;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BodyAttacher extends CharacterPartAttacher<Body, Background> {

    public BodyAttacher(
        CharacterPartBuilder<Body> sourcePartBuilder,
        List<CharacterPartAttacher<?, Body>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return CharacterBuilderConstants.BODY_ANCHOR;
    }

    @Override
    protected String getConnectorId() {
        // here we use clothing anchor as a connector
        return CharacterBuilderConstants.CLOTHING_ANCHOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.BODY_GROUP;
    }
}
