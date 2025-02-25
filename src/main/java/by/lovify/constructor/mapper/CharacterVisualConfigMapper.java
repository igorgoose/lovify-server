package by.lovify.constructor.mapper;

import by.lovify.constructor.dto.CharacterConfigDTO;
import by.lovify.constructor.dto.ColoredCustomizationConfigDTO;
import by.lovify.constructor.model.CharacterVisualConfig;
import by.lovify.constructor.model.ColoredCustomizationConfig;
import by.lovify.constructor.model.CustomizationConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CharacterVisualConfigMapper {

    public CharacterVisualConfig fromCharacterConfigDto(CharacterConfigDTO dto) {
        return new CharacterVisualConfig(
            dto.skinColor(),
            fromColoredCustomizationConfigDto(dto.hair()),
            fromColoredCustomizationConfigDto(dto.eyes()),
            new CustomizationConfig(dto.bodyType().id()),
            new CustomizationConfig(dto.faceType().id()),
            new CustomizationConfig(dto.eyebrows().id()),
            new CustomizationConfig(dto.nose().id()),
            new CustomizationConfig(dto.mouth().id()),
            dto.mustache().map(it -> new CustomizationConfig(it.id())),
            new CustomizationConfig(dto.topClothing().id()),
            new CustomizationConfig(dto.bottomClothing().id()),
            new CustomizationConfig(dto.shoes().id()),
            new CustomizationConfig(dto.rightLeg().id()),
            new CustomizationConfig(dto.leftLeg().id())

        );
    }

    private ColoredCustomizationConfig fromColoredCustomizationConfigDto(ColoredCustomizationConfigDTO dto) {
        return new ColoredCustomizationConfig(dto.id(), dto.color());
    }
}
