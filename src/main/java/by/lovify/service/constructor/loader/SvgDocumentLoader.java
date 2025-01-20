package by.lovify.service.constructor.loader;

import by.lovify.model.CustomizationConfig;
import org.w3c.dom.svg.SVGDocument;

public interface SvgDocumentLoader {

    SVGDocument load(CustomizationConfig customizationConfig);
}
