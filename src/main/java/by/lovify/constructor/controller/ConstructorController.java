package by.lovify.constructor.controller;

import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.service.CharacterPreviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/constructor")
public class ConstructorController {
    private final CharacterPreviewService characterPreviewService;


    @PostMapping(value = "/characters/preview", produces = "image/png")
    public Resource generateCharacterPreview(@RequestBody CharacterVisualConfig visualConfig) {
        return characterPreviewService.generateCharacterPreview(visualConfig);
    }
}
