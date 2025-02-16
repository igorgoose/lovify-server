package by.lovify.constructor.model;

import lombok.Builder;

@Builder
public record CharacterVisualConfig(
    String skinColor,
    ColoredCustomizationConfig hair,
    ColoredCustomizationConfig eyes,
    CustomizationConfig bodyType,
    CustomizationConfig faceType,
    CustomizationConfig eyebrows,
    CustomizationConfig nose,
    CustomizationConfig mouth,
    CustomizationConfig topClothing,
    CustomizationConfig bottomClothing,
    CustomizationConfig shoes,
    CustomizationConfig rightLeg,
    CustomizationConfig leftLeg
) {

}
