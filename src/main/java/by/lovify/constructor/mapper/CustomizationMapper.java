package by.lovify.constructor.mapper;

import by.lovify.constructor.dto.CustomizationLinkDTO;
import by.lovify.constructor.model.CustomizationModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomizationMapper {

    public CustomizationLinkDTO customizationModelToLinkDTO(CustomizationModel customizationModel) {
        return new CustomizationLinkDTO(customizationModel.getId().toString(), customizationModel.getIconUrl());
    }
}
