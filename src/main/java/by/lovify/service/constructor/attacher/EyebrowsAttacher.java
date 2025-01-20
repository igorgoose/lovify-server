package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Eyebrows;
import by.lovify.model.constructor.part.Face;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
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
        return "connect-eyes-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-eyes";
    }

    @Override
    protected String getDestinationGroupId() {
        return "eyebrows-group";
    }
}
