package by.lovify.service.constructor.attacher;

import by.lovify.model.constructor.part.Background;
import by.lovify.model.constructor.part.Face;
import by.lovify.service.constructor.attacher.positioner.CharacterPartPositioner;
import by.lovify.service.constructor.builder.CharacterPartBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FaceAttacher extends CharacterPartAttacher<Face, Background> {

    public FaceAttacher(
        CharacterPartBuilder<Face> sourcePartBuilder,
        List<CharacterPartAttacher<?, Face>> attachers,
        CharacterPartPositioner characterPartPositioner
    ) {
        super(sourcePartBuilder, attachers, characterPartPositioner);
    }

    @Override
    public String getAnchorId() {
        return "connect-head-grip";
    }

    @Override
    protected String getConnectorId() {
        return "connect-face";
    }

    @Override
    protected String getDestinationGroupId() {
        return "face-group";
    }
}
