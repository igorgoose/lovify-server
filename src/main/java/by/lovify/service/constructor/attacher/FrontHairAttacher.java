package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Background;
import by.lovify.model.constructor.part.FrontHair;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class FrontHairAttacher extends CharacterPartAttacher<FrontHair, Background> {

    public FrontHairAttacher(
        CharacterPartBuilder<FrontHair> sourcePartBuilder,
        List<CharacterPartAttacher<?, FrontHair>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return "connect-hair-grip";
    }

    @Override
    protected String getConnectorId() {
        return "connect-hair";
    }

    @Override
    protected String getDestinationGroupId() {
        return "front-hair-group";
    }
}
