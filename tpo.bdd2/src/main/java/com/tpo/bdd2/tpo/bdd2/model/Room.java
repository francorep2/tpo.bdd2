package com.tpo.bdd2.tpo.bdd2.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Node
@Data
@NoArgsConstructor
@Slf4j
public class Room {

    @Schema(description = "Habitacion ID (numero de habitacion) ", example = "1")
    @Id
    private String roomId;

    @Schema(description = "Amenities de habitacion", example = "Amenities A")
    @Property
    private List<String> amenities;

    @Schema(description = "Disponibilidad", example = "true")
    private boolean isAvailable;

    @Schema(description = "Precio", example = "1000")
    private double price;

    @Schema(description = "Disponible desde", example = "2024-10-25")
    private LocalDate availableFrom;

    @Schema(description = "Disponible hasta", example = "2024-10-30")
    private LocalDate availableUntil;

}