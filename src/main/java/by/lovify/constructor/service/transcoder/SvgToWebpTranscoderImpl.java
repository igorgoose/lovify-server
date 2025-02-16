package by.lovify.constructor.service.transcoder;

import lombok.RequiredArgsConstructor;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.svg.SVGDocument;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.imageio.ImageIO;

@RequiredArgsConstructor
//@Component
class SvgToWebpTranscoderImpl implements SvgTranscoder {


    @Override
    public void transcode(SVGDocument svgDocument, OutputStream outputStream) {
        try (
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(os)
        ) {
            SVGGraphics2D graphics2D = new SVGGraphics2D(svgDocument);
            graphics2D.stream(
                svgDocument.getRootElement(),
                writer,
                true,
                false
            );

            try (ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray())) {
                BufferedImage svgImage = ImageIO.read(is);
                Raster raster = svgImage.getData();

                if (!ImageIO.write(svgImage, "jpg", outputStream)) {
                    throw new RuntimeException("No writer for webp found");
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
