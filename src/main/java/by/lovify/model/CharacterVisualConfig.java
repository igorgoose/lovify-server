package by.lovify.model;

public record CharacterVisualConfig(
    String skinColor,
    ColoredCustomizationConfig hair,
    ColoredCustomizationConfig eyes,
    CustomizationConfig bodyType,
    CustomizationConfig faceType,
    CustomizationConfig nose,
    CustomizationConfig mouth,
    CustomizationConfig topClothing,
    CustomizationConfig bottomClothing,
    CustomizationConfig shoes
) {

}
