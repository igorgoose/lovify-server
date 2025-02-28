package by.lovify.constructor.model;

import lombok.Builder;

import java.util.Optional;

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
    Optional<CustomizationConfig> mustache,
    CustomizationConfig topClothing,
    CustomizationConfig bottomClothing,
    CustomizationConfig shoes,
    CustomizationConfig rightLeg,
    CustomizationConfig leftLeg
) {

}
