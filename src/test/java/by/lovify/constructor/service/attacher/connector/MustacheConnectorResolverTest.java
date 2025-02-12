package by.lovify.constructor.service.attacher.connector;

import by.lovify.constructor.constant.CharacterBuilderConstants;
import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.CustomizationConfig;
import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.part.Mustache;
import by.lovify.constructor.service.builder.MustacheBuilder;
import by.lovify.test.util.ClasspathSvgDocumentLoader;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MustacheConnectorResolverTest {

    private final MustacheConnectorResolver resolver = new MustacheConnectorResolver();
    private final MustacheBuilder builder = new MustacheBuilder(
        new ClasspathSvgDocumentLoader()
    );

    @Test
    void resolveConnector_whenNoMouthExpression_defaultConnectorResolved() {
        var context = new CharacterBuilderContext(
            CharacterVisualConfig.builder()
                .mustache(new CustomizationConfig().setId("edited_svgs/ready/mustache-1.svg"))
                .mouth(new CustomizationConfig().setId("mouth-1"))
                .build()
        );
        Mustache mustache = builder.build(context);

        Optional<Element> element =
            resolver.resolveConnector(mustache, CharacterBuilderConstants.NOSE_CONNECTOR, context);

        assertThat(element).isPresent()
            .get()
            .returns(CharacterBuilderConstants.NOSE_CONNECTOR, it -> it.getAttribute("id"))
            .extracting(it -> it.getAttribute("class"))
            .matches(it -> it.contains("variant-mouth-mouth-expression-none"));
    }

    @Test
    void resolveConnector_whenMouthExpression_correspondingConnectorResolved() {
        var context = new CharacterBuilderContext(
            CharacterVisualConfig.builder()
                .mustache(new CustomizationConfig().setId("edited_svgs/ready/mustache-1.svg"))
                .mouth(new CustomizationConfig().setId("mouth-expression-silly"))
                .build()
        );
        Mustache mustache = builder.build(context);

        Optional<Element> element =
            resolver.resolveConnector(mustache, CharacterBuilderConstants.NOSE_CONNECTOR, context);

        assertThat(element).isPresent()
            .get()
            .returns(CharacterBuilderConstants.NOSE_CONNECTOR, it -> it.getAttribute("id"))
            .extracting(it -> it.getAttribute("class"))
            .matches(it -> it.contains("variant-mouth-mouth-expression-silly"));
    }
}