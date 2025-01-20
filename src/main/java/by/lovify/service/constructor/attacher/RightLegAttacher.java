package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Background;
import by.lovify.model.constructor.part.RightLeg;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RightLegAttacher extends CharacterPartAttacher<RightLeg, Background> {

    public RightLegAttacher(
        CharacterPartBuilder<RightLeg> partBuilder,
        List<CharacterPartAttacher<?, RightLeg>> characterPartAttachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(partBuilder, characterPartAttachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return "connect-righthip-anchor";
    }

    @Override
    protected String getConnectorId() {
        return "connect-hip";
    }

    @Override
    protected String getDestinationGroupId() {
        return "right-leg-group";
    }
}
