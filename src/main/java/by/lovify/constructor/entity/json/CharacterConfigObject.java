package by.lovify.constructor.entity.json;

import lombok.Data;

import java.util.Optional;

@Data
public class CharacterConfigObject {

    private String skinColor;
    private CharacterColoredCustomizationObject hair;
    private CharacterColoredCustomizationObject eyes;
    private CharacterCustomizationObject bodyType;
    private CharacterCustomizationObject faceType;
    private CharacterCustomizationObject eyebrows;
    private CharacterCustomizationObject nose;
    private CharacterCustomizationObject mouth;
    private Optional<CharacterCustomizationObject> mustache;
    private CharacterCustomizationObject topClothing;
    private CharacterCustomizationObject bottomClothing;
    private CharacterCustomizationObject shoes;
    private CharacterCustomizationObject rightLeg;
    private CharacterCustomizationObject leftLeg;
}
