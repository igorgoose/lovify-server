package by.lovify.constructor.service;

import by.lovify.constructor.dto.CharacterConfigDTO;
import by.lovify.constructor.entity.CharacterDefaultConfigEntity;
import by.lovify.constructor.enums.Gender;
import by.lovify.constructor.exception.DefaultConfigNotFoundException;
import by.lovify.constructor.mapper.CharacterDefaultConfigMapper;
import by.lovify.constructor.repository.CharacterDefaultConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharacterService {

    private final CharacterDefaultConfigRepository characterDefaultConfigRepository;

    public CharacterDefaultConfigEntity getDefaultConfig(Gender gender) {
        return characterDefaultConfigRepository.findByGender(gender)
            .orElseThrow(() -> new DefaultConfigNotFoundException(gender));
    }
}
