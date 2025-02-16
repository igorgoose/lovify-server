package by.lovify.constructor.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("features.constructor.preview")
public record CharacterPreviewProperties(
    @DefaultValue("100")
    Integer width,
    @DefaultValue("100")
    Integer height,
    @DefaultValue("background.svg")
    String backgroundId
) {

}
