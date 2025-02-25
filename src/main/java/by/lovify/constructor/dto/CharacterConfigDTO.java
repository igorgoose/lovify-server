package by.lovify.constructor.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Optional;

@Builder
public record CharacterConfigDTO(
    @NotNull
    String skinColor,
    @NotNull
    ColoredCustomizationConfigDTO hair,
    @NotNull
    ColoredCustomizationConfigDTO eyes,
    @NotNull
    CustomizationConfigDTO bodyType,
    @NotNull
    CustomizationConfigDTO faceType,
    @NotNull
    CustomizationConfigDTO eyebrows,
    @NotNull
    CustomizationConfigDTO nose,
    @NotNull
    CustomizationConfigDTO mouth,
    @NotNull
    Optional<CustomizationConfigDTO> mustache,
    @NotNull
    CustomizationConfigDTO topClothing,
    @NotNull
    CustomizationConfigDTO bottomClothing,
    @NotNull
    CustomizationConfigDTO shoes,
    @NotNull
    CustomizationConfigDTO rightLeg,
    @NotNull
    CustomizationConfigDTO leftLeg
) {
}
