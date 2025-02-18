package by.lovify.constructor.dto;

public record CharacterConfigDTO(
    String skinColor,
    ColoredCustomizationConfigDTO hair,
    ColoredCustomizationConfigDTO eyes,
    CustomizationConfigDTO bodyType,
    CustomizationConfigDTO faceType,
    CustomizationConfigDTO eyebrows,
    CustomizationConfigDTO nose,
    CustomizationConfigDTO mouth,
    CustomizationConfigDTO topClothing,
    CustomizationConfigDTO bottomClothing,
    CustomizationConfigDTO shoes,
    CustomizationConfigDTO rightLeg,
    CustomizationConfigDTO leftLeg
) {
}
