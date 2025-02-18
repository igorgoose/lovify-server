package by.lovify.constructor.entity;

import by.lovify.constructor.entity.json.CharacterCustomizationObject;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data
@Table(name = "character")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String gender;
    @Type(JsonBinaryType.class)
    @Column(name = "visual_config", columnDefinition = "jsonb")
    private CharacterCustomizationObject customizations;
}
