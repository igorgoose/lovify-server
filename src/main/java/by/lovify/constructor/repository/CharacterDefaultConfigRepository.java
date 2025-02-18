package by.lovify.constructor.repository;

import by.lovify.constructor.enums.Gender;
import by.lovify.constructor.entity.CharacterDefaultConfigEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterDefaultConfigRepository extends JpaRepository<CharacterDefaultConfigEntity, Enum<Gender>> {
    Optional<CharacterDefaultConfigEntity> findByGender(Gender gender);
}
