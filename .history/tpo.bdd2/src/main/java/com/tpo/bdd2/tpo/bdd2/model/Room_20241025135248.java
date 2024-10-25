package com.tpo.bdd2.tpo.bdd2.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Relationship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Room {

    @Schema(description = "Habitacion ID (numero de habitacion) ", example = "1")
    @Id
    @GeneratedValue
    private Long roomId;

    @Schema(description = "Amenities de habitacion", example = "Amenities A")
    @Relationship("HAS_AMENITIES")
    private List<String> amenities;

    @Schema(description = "Disponibilidad", example = "true")
    private boolean isAvaible;

    private double price;

    private LocalDate availableFrom;

    private LocalDate availableUntil;

    
}
