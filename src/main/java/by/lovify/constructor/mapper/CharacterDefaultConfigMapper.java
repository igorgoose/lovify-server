package by.lovify.constructor.mapper;

import by.lovify.constructor.dto.CharacterConfigDTO;
import by.lovify.constructor.dto.ColoredCustomizationConfigDTO;
import by.lovify.constructor.dto.CustomizationConfigDTO;
import by.lovify.constructor.entity.CharacterDefaultConfigEntity;
import by.lovify.constructor.entity.json.CharacterColoredCustomizationObject;
import by.lovify.constructor.entity.json.CharacterConfigObject;
import by.lovify.constructor.entity.json.CharacterCustomizationObject;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class CharacterDefaultConfigMapper {

    public CharacterConfigDTO defaultConfigEntityToDTO(CharacterDefaultConfigEntity entity) {
        CharacterConfigObject entityCustomizationConfig = entity.getCustomizations();
        return CharacterConfigDTO.builder()
            .skinColor(entityCustomizationConfig.getSkinColor())
            .hair(coloredConfigToDTO(entityCustomizationConfig.getHair()))
            .eyes(coloredConfigToDTO(entityCustomizationConfig.getEyes()))
            .bodyType(customizationToDTO(entityCustomizationConfig.getBodyType()))
            .faceType(customizationToDTO(entityCustomizationConfig.getFaceType()))
            .eyebrows(customizationToDTO(entityCustomizationConfig.getEyebrows()))
            .nose(customizationToDTO(entityCustomizationConfig.getNose()))
            .mouth(customizationToDTO(entityCustomizationConfig.getMouth()))
            .mustache(
                entityCustomizationConfig.getMustache()
                    .map(CharacterDefaultConfigMapper::customizationToDTO)
            )
            .topClothing(customizationToDTO(entityCustomizationConfig.getTopClothing()))
            .bottomClothing(customizationToDTO(entityCustomizationConfig.getBottomClothing()))
            .shoes(customizationToDTO(entityCustomizationConfig.getShoes()))
            .rightLeg(customizationToDTO(entityCustomizationConfig.getRightLeg()))
            .leftLeg(customizationToDTO(entityCustomizationConfig.getLeftLeg()))
            .build();
    }

    public ColoredCustomizationConfigDTO coloredConfigToDTO(CharacterColoredCustomizationObject entity) {
        return new ColoredCustomizationConfigDTO(
            entity.getStyle(),
            entity.getColor()
        );
    }

    public CustomizationConfigDTO customizationToDTO(CharacterCustomizationObject entity) {
        return new CustomizationConfigDTO(
            entity.getId()
        );
    }
}
