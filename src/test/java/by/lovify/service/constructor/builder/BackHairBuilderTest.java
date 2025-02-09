package by.lovify.service.constructor.builder;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.ColoredCustomizationConfig;
import by.lovify.model.constructor.CharacterBuilderContext;
import by.lovify.model.constructor.part.BackHair;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import by.lovify.test.util.ClasspathSvgDocumentLoader;
import org.junit.jupiter.api.Test;

class BackHairBuilderTest {

    private final SvgDocumentLoader loader = new ClasspathSvgDocumentLoader();
    private final BackHairBuilder backHairBuilder = new BackHairBuilder(loader);

    @Test
    void createPart() {
        var customizationConfig = new ColoredCustomizationConfig();
        customizationConfig.setId("edited_svgs/ready/hair-med-1.svg");

        CharacterVisualConfig visualConfig = CharacterVisualConfig.builder()
            .hair(customizationConfig)
            .build();
        CharacterBuilderContext context = new CharacterBuilderContext(visualConfig);

        BackHair backHair = backHairBuilder.build(context);
        System.out.println(backHair);
    }
}