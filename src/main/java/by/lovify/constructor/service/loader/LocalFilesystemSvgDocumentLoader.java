package by.lovify.constructor.service.loader;

import by.lovify.constructor.model.CustomizationConfig;
import by.lovify.constructor.properties.LocalFileSystemSvgLoaderProperties;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGDocument;

import java.io.IOException;
import java.nio.file.Path;

@ConditionalOnBean(LocalFileSystemSvgLoaderProperties.class)
@Component
class LocalFilesystemSvgDocumentLoader implements SvgDocumentLoader {

    private static final String SVG_EXTENSION = ".svg";
    private static final SAXSVGDocumentFactory factory =
        new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());
    private final Path svgDocumentBasePath;

    public LocalFilesystemSvgDocumentLoader(LocalFileSystemSvgLoaderProperties properties) {
        this.svgDocumentBasePath = Path.of(properties.basePath());
    }

    @Override
    public SVGDocument load(CustomizationConfig customizationConfig) {
        // todo validation of path(probably with regex in customizationConfig)
        Path svgPath = svgDocumentBasePath.resolve(customizationConfig.getId() + SVG_EXTENSION);
        try {
            return factory.createSVGDocument(svgPath.toUri().toString());
        } catch (IOException e) {
            // todo better handling
            throw new RuntimeException("Could not read SVG document from " + svgDocumentBasePath, e);
        }
    }
}
