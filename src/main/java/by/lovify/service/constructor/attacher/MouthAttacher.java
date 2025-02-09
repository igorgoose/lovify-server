package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Face;
import by.lovify.model.constructor.part.Mouth;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
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
        return "connect-mouth-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-mouth";
    }

    @Override
    protected String getDestinationGroupId() {
        return "mouth-group";
    }
}
