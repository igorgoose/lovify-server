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
        return new CharacterConfigDTO(
            entityCustomizationConfig.getSkinColor(),
            coloredConfigToDTO(entityCustomizationConfig.getHair()),
            coloredConfigToDTO(entityCustomizationConfig.getEyes()),
            customizationToDTO(entityCustomizationConfig.getBodyType()),
            customizationToDTO(entityCustomizationConfig.getFaceType()),
            customizationToDTO(entityCustomizationConfig.getEyebrows()),
            customizationToDTO(entityCustomizationConfig.getNose()),
            customizationToDTO(entityCustomizationConfig.getMouth()),
            customizationToDTO(entityCustomizationConfig.getTopClothing()),
            customizationToDTO(entityCustomizationConfig.getBottomClothing()),
            customizationToDTO(entityCustomizationConfig.getShoes()),
            customizationToDTO(entityCustomizationConfig.getRightLeg()),
            customizationToDTO(entityCustomizationConfig.getLeftLeg())
        );
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
