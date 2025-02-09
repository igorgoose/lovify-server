package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.BackHair;
import by.lovify.model.constructor.part.Background;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class BackHairAttacher extends CharacterPartAttacher<BackHair, Background> {

    public BackHairAttacher(
        CharacterPartBuilder<BackHair> sourcePartBuilder,
        List<CharacterPartAttacher<?, BackHair>> attachers,
        @Qualifier("atBottomLayerPositioner") CharacterPartPositioner characterPartPositioner
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
        return "back-hair-group";
    }
}
