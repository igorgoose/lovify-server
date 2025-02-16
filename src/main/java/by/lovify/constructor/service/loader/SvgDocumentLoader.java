package by.lovify.constructor.service.loader;

import by.lovify.constructor.model.CustomizationConfig;
import org.w3c.dom.svg.SVGDocument;

public interface SvgDocumentLoader {

    SVGDocument load(CustomizationConfig customizationConfig);
}
