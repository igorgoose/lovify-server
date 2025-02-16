package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.ColoredCustomizationConfig;
import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.part.BackHair;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
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