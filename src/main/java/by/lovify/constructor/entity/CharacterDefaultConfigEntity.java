package by.lovify.constructor.entity;

import by.lovify.constructor.entity.json.CharacterConfigObject;
import by.lovify.constructor.enums.Gender;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Data
@Table(name = "default_config")
public class CharacterDefaultConfigEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Type(JsonBinaryType.class)
    @Column(name = "visual_config", nullable = false, columnDefinition = "jsonb")
    private CharacterConfigObject customizations;
}
