package by.lovify.constructor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class ColoredCustomizationConfig extends CustomizationConfig {
    private String color;
}
