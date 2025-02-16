package by.lovify.constructor.service.attacher;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.model.constructor.part.Background;
import by.lovify.constructor.model.constructor.part.RightLeg;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
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
        return CharacterBuilderConstants.RIGHT_HIP_ANCHOR;
    }

    @Override
    protected String getConnectorId() {
        return CharacterBuilderConstants.HIP_CONNECTOR;
    }

    @Override
    protected String getDestinationGroupId() {
        return CharacterBuilderConstants.RIGHT_LEG_GROUP;
    }
}
