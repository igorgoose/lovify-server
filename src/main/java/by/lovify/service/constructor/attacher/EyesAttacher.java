package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Eyes;
import by.lovify.model.constructor.part.Face;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
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
        return "connect-eyes-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-eyes";
    }

    @Override
    protected String getDestinationGroupId() {
        return "eyes-group";
    }
}
