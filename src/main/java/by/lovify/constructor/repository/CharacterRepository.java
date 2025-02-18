package by.lovify.constructor.repository;

import by.lovify.constructor.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CharacterRepository extends JpaRepository<CharacterEntity, UUID> {
}
