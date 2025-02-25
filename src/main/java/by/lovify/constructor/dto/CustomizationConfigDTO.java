package by.lovify.constructor.dto;

import jakarta.validation.constraints.NotNull;

public record CustomizationConfigDTO(
    @NotNull
    String id
) {
}
