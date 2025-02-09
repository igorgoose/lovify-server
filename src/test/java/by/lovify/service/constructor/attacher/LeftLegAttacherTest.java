package by.lovify.service.constructor.attacher;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.CustomizationConfig;
import by.lovify.model.constructor.Anchor;
import by.lovify.model.constructor.CharacterBuilderContext;
import by.lovify.properties.CharacterPreviewProperties;
import by.lovify.service.constructor.attacher.positioner.AtBottomLayerPositioner;
import by.lovify.service.constructor.builder.BackgroundBuilder;
import by.lovify.service.constructor.builder.LeftLegBuilder;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import by.lovify.test.util.ClasspathSvgDocumentLoader;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D.Float;
import java.util.List;

public class LeftLegAttacherTest {

    private final SvgDocumentLoader loader = new ClasspathSvgDocumentLoader();
    private final LeftLegBuilder legBuilder = new LeftLegBuilder(loader);
    private final CharacterPreviewProperties properties;
    private final BackgroundBuilder backgroundBuilder;

    {
        properties = mock(CharacterPreviewProperties.class);
        when(properties.backgroundId()).thenReturn("edited_svgs/ready/background.svg");
        backgroundBuilder = new BackgroundBuilder(loader, properties, List.of());
    }

    @Test
    public void createPart() {
        var config = CharacterVisualConfig.builder()
            .leftLeg(new CustomizationConfig().setId("edited_svgs/ready/leg-7.svg"))
            .build();
        var context = new CharacterBuilderContext(config);
        LeftLegAttacher attacher = new LeftLegAttacher(legBuilder, List.of(), new AtBottomLayerPositioner());
        var background = backgroundBuilder.buildInitialPart(context);
        var anchor = new Anchor("", new Float(0, 0), 3.6f, null);

        attacher.attach(background, anchor, context);

        // write it somewhere and check by looking at it
    }

}
