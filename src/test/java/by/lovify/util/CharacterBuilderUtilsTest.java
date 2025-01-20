package by.lovify.util;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import by.lovify.model.CustomizationConfig;
import by.lovify.model.constructor.Anchor;
import by.lovify.model.constructor.AttachedPart;
import by.lovify.model.constructor.part.Background;
import by.lovify.service.constructor.loader.SvgDocumentLoader;
import by.lovify.test.util.ClasspathSvgDocumentLoader;
import org.apache.batik.anim.dom.SVGOMGElement;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.Optional;

class CharacterBuilderUtilsTest {

    private final SvgDocumentLoader loader = new ClasspathSvgDocumentLoader();

    @Test
    void findAnchors() {
        var customizationConfig = new CustomizationConfig()
            .setId("edited_svgs/ready/background.svg");

        SVGDocument svgDocument = loader.load(customizationConfig);
        var part = new Background(svgDocument.getRootElement());
        var attachedPart = new AttachedPart<>(part, new AffineTransform());

        Element anchorElement = svgDocument.getElementById("connect-body-anchor");

        List<Anchor> anchors = CharacterBuilderUtils.findAnchors(attachedPart);
        assertAll(
            () -> assertThat(anchors).hasSize(1),
            () -> assertThat(anchors)
                .filteredOn("id", "connect-body-anchor")
                .hasSize(1),
            () -> assertEquals(anchorElement, anchors.getFirst().element())
        );
    }

    @Test
    void findGroupById() {
        var customizationConfig = new CustomizationConfig()
            .setId("edited_svgs/ready/background.svg");

        SVGDocument svgDocument = loader.load(customizationConfig);
        Optional<SVGOMGElement> groupOptional =
            CharacterBuilderUtils.findGroupById(svgDocument.getRootElement(), "body-group");
        assertAll(
            () -> assertThat(groupOptional).isPresent()
        );
    }

}