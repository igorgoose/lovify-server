package by.lovify.test.util;

import by.lovify.constructor.model.CustomizationConfig;
import by.lovify.constructor.service.loader.SvgDocumentLoader;
import lombok.SneakyThrows;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.svg.SVGDocument;

public class ClasspathSvgDocumentLoader implements SvgDocumentLoader {

    private static final SAXSVGDocumentFactory factory =
        new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());

    @SneakyThrows
    @Override
    public SVGDocument load(CustomizationConfig customizationConfig) {
        return factory.createSVGDocument(
            getClass().getClassLoader().getResource(customizationConfig.getId()).toURI().toString()
        );
    }
}
