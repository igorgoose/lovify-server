package by.lovify.constructor.repository;

import by.lovify.constructor.entity.ColoredCustomizationEntity;
import by.lovify.constructor.enums.CustomizationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface CustomizationColorRepository extends JpaRepository<ColoredCustomizationEntity, UUID> {

    @Query(
        value = """
            SELECT customizationColor.hexColor
            FROM ColoredCustomizationEntity customizationColor
            WHERE customizationColor.customizationType = :customizationType
            """
    )
    Set<String> getColorsForCustomization(CustomizationType customizationType);
}
