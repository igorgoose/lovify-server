package by.lovify.constructor.controller;

import by.lovify.constructor.enums.Gender;
import by.lovify.constructor.dto.CharacterConfigDTO;
import by.lovify.constructor.mapper.CharacterDefaultConfigMapper;
import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.service.CharacterPreviewService;
import by.lovify.constructor.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/constructor")
public class ConstructorController {

    private final CharacterPreviewService characterPreviewService;
    private final CharacterService characterService;


    @GetMapping("/characters/default")
    ResponseEntity<CharacterConfigDTO> getDefaultCharacterConfig(@RequestParam Gender gender) {
        return new ResponseEntity<>(
            CharacterDefaultConfigMapper.defaultConfigEntityToDTO(characterService.getDefaultConfig(gender)),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/characters/preview", produces = "image/png")
    public Resource generateCharacterPreview(@RequestBody CharacterVisualConfig visualConfig) {
        return characterPreviewService.generateCharacterPreview(visualConfig);
    }
}
