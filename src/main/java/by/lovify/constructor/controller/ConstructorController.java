package by.lovify.constructor.controller;

import by.lovify.constructor.dto.CharacterConfigDTO;
import by.lovify.constructor.enums.Gender;
import by.lovify.constructor.mapper.CharacterDefaultConfigMapper;
import by.lovify.constructor.mapper.CharacterVisualConfigMapper;
import by.lovify.constructor.service.CharacterPreviewService;
import by.lovify.constructor.service.CharacterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/constructor")
public class ConstructorController {

    private final CharacterPreviewService characterPreviewService;
    private final CharacterService characterService;


    @GetMapping("/characters/default")
    public CharacterConfigDTO getDefaultCharacterConfig(@RequestParam Gender gender) {
        return CharacterDefaultConfigMapper.defaultConfigEntityToDTO(characterService.getDefaultConfig(gender));
    }

    @PostMapping(value = "/characters/preview", produces = "image/png")
    public Resource generateCharacterPreview(@RequestBody @Valid CharacterConfigDTO characterConfigDTO) {
        return characterPreviewService.generateCharacterPreview(
            CharacterVisualConfigMapper.fromCharacterConfigDto(characterConfigDTO)
        );
    }
}
