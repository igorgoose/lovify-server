package by.lovify.constructor.repository;

import by.lovify.constructor.entity.CustomizationEntity;
import by.lovify.constructor.enums.CustomizationType;
import by.lovify.constructor.enums.Gender;
import by.lovify.constructor.model.CustomizationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CustomizationRepository extends JpaRepository<CustomizationEntity, UUID> {

    @Query(
        value = """
            SELECT customization.id AS id, customization.iconUrl AS iconUrl
            FROM CustomizationEntity customization
            WHERE (customization.type = :type AND customization.gender = :gender)
            """
    )
    List<CustomizationModel> getCustomizations(CustomizationType type, Gender gender);
}
