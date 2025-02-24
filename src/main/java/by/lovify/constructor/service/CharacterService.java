package by.lovify.constructor.service;

import by.lovify.constructor.entity.CharacterDefaultConfigEntity;
import by.lovify.constructor.enums.CustomizationType;
import by.lovify.constructor.enums.Gender;
import by.lovify.constructor.exception.DefaultConfigNotFoundException;
import by.lovify.constructor.model.CustomizationModel;
import by.lovify.constructor.repository.CharacterDefaultConfigRepository;
import by.lovify.constructor.repository.CustomizationColorRepository;
import by.lovify.constructor.repository.CustomizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CharacterService {

    private final CharacterDefaultConfigRepository characterDefaultConfigRepository;
    private final CustomizationRepository customizationRepository;
    private final CustomizationColorRepository customizationColorRepository;

    public CharacterDefaultConfigEntity getDefaultConfig(Gender gender) {
        return characterDefaultConfigRepository.findByGender(gender)
            .orElseThrow(() -> new DefaultConfigNotFoundException(gender));
    }

    public List<CustomizationModel> getCustomizations(CustomizationType type, Gender gender) {
        return customizationRepository.getCustomizations(type, gender);
    }

    public Set<String> getCustomizationColors(CustomizationType type) {
        return customizationColorRepository.getColorsForCustomization(type);
    }
}
