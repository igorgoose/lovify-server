package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Face;
import by.lovify.model.constructor.part.Nose;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class NoseAttacher extends CharacterPartAttacher<Nose, Face> {

    public NoseAttacher(
        CharacterPartBuilder<Nose> sourcePartBuilder,
        List<CharacterPartAttacher<?, Nose>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return "connect-nose-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-nose";
    }

    @Override
    protected String getDestinationGroupId() {
        return "nose-group";
    }
}
