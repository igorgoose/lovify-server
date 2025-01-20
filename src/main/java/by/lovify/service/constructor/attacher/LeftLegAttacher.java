package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Background;
import by.lovify.model.constructor.part.LeftLeg;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeftLegAttacher extends CharacterPartAttacher<LeftLeg, Background> {

    public LeftLegAttacher(
        CharacterPartBuilder<LeftLeg> partBuilder,
        List<CharacterPartAttacher<?, LeftLeg>> characterPartAttachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(partBuilder, characterPartAttachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return "connect-lefthip-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-hip";
    }

    @Override
    protected String getDestinationGroupId() {
        return "left-leg-group";
    }
}
