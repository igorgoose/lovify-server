package by.lovify.constructor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ColoredCustomizationConfig extends CustomizationConfig {

    private String color;

    public ColoredCustomizationConfig(String style, String color) {
        super(style);
        this.color = color;
    }
}
