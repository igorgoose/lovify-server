package by.lovify.service.constructor.transcoder;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.springframework.stereotype.Component;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGRect;

import java.io.OutputStream;

@Component
class BatikSvgToPngTranscoder implements SvgTranscoder {

    @Override
    public void transcode(SVGDocument svgDocument, OutputStream outputStream) {
        TranscoderInput svgInput = new TranscoderInput(svgDocument);
        TranscoderOutput pngImageOutput = new TranscoderOutput(outputStream);
        PNGTranscoder transcoder = new PNGTranscoder();

        SVGRect viewBox = svgDocument.getRootElement().getViewBox().getBaseVal();
        transcoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, viewBox.getWidth());
        transcoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, viewBox.getHeight());

        try {
            transcoder.transcode(svgInput, pngImageOutput);
        } catch (TranscoderException e) {
            // todo better handling or even throw something
            throw new RuntimeException(e);
        }
    }
}
