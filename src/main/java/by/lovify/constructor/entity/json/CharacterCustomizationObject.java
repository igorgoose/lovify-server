package by.lovify.constructor.entity.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterCustomizationObject {

    private String id;
}
