package by.lovify.util;

import lombok.experimental.UtilityClass;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.svg.SVGDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class SvgIOUtils {

    public static void writeToFile(SVGDocument svgDocument, Path path) {
        SVGGraphics2D graphics2D = new SVGGraphics2D(svgDocument);
        try {
            graphics2D.stream(
                svgDocument.getRootElement(),
                Files.newBufferedWriter(path),
                true,
                false
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
