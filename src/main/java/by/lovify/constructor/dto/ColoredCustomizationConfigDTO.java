package by.lovify.constructor.dto;

import jakarta.validation.constraints.NotNull;

public record ColoredCustomizationConfigDTO(
    @NotNull
    String id,
    @NotNull
    String color
) {
}
