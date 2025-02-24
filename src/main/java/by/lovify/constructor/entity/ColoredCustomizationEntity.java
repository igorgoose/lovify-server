package by.lovify.constructor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

import lombok.Data;

@Data
@Entity
@Table(name = "customization_color")
public class ColoredCustomizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    String customizationType;
    @Column(name = "hex", nullable = false)
    private String hexColor;
}
