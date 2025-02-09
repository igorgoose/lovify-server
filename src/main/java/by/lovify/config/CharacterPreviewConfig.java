package by.lovify.config;

import by.lovify.properties.CharacterPreviewProperties;
import by.lovify.properties.LocalFileSystemSvgLoaderProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
    CharacterPreviewProperties.class,
})
@Configuration
public class CharacterPreviewConfig {

    private static final String LOCAL_FILE_SYSTEM_SVG_LOADER_LOCAL_FILE_SYSTEM_PREFIX =
        "features.constructor.preview.svg-loader.local-file-system";
    private static final String LOCAL_FILE_SYSTEM_SVG_LOADER_LOCAL_FILE_SYSTEM_BASE_PATH =
        LOCAL_FILE_SYSTEM_SVG_LOADER_LOCAL_FILE_SYSTEM_PREFIX + ".base-path";

    @ConditionalOnProperty(LOCAL_FILE_SYSTEM_SVG_LOADER_LOCAL_FILE_SYSTEM_BASE_PATH)
    @Bean
    public LocalFileSystemSvgLoaderProperties localFileSystemSvgLoaderProperties(
        ApplicationContext applicationContext
    ) {
        return Binder.get(applicationContext.getEnvironment())
            .bind(
                LOCAL_FILE_SYSTEM_SVG_LOADER_LOCAL_FILE_SYSTEM_PREFIX,
                LocalFileSystemSvgLoaderProperties.class
            )
            .orElseThrow(() -> new IllegalStateException("Could not bind LocalFileSystemSvgLoaderProperties"));
    }
}
