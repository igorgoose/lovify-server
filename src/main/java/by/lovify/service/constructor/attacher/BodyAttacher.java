package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Background;
import by.lovify.model.constructor.part.Body;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
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
        return "connect-body-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-clothing-anchor";
    }

    @Override
    protected String getDestinationGroupId() {
        return "body-group";
    }
}
