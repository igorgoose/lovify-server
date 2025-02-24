package by.lovify.constructor.service;

import by.lovify.constructor.service.transcoder.SvgTranscoder;
import by.lovify.constructor.model.CharacterVisualConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class CharacterPreviewService {

    private final CharacterSvgService characterSvgService;
    private final SvgTranscoder transcoder;

    public Resource generateCharacterPreview(CharacterVisualConfig visualConfig) {
        SVGDocument characterSvgDocument = characterSvgService.build(visualConfig);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            transcoder.transcode(characterSvgDocument, outputStream);
            return new ByteArrayResource(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
