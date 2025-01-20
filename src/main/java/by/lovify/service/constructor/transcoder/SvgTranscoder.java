package by.lovify.service.constructor.transcoder;

import org.w3c.dom.svg.SVGDocument;

import java.io.OutputStream;

public interface SvgTranscoder {

    void transcode(SVGDocument svgDocument, OutputStream outputStream);
}
