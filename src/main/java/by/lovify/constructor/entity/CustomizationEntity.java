package by.lovify.constructor.entity;

import by.lovify.constructor.entity.json.CustomizationParamsObject;
import by.lovify.constructor.enums.CustomizationType;
import by.lovify.constructor.enums.Gender;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(name = "customization")
public class CustomizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CustomizationType type;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "icon_url", nullable = false)
    private String iconUrl;
    @Type(JsonBinaryType.class)
    @Column(name = "params", columnDefinition = "jsonb")
    private CustomizationParamsObject params;
}
