package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Node
@AllArgsConstructor
public class Hotel {

    @Schema(description = "Hotel ID ", example = "1")
    @Id
    private String id; 

    @Schema(description = "Nombre Hotel", example = "Hotel Name")
    private String name;

    @Schema(description = "Descripcion Hotel", example = "Hotel Description")
    @Relationship(type = "LOCATE_IN")
    private Address address;

    @Schema(description = "Telefono Hotel", example = "Hotel Phone")
    private List<String> phone;

    @Schema(description = "Email Hotel", example = "Hotel Email")
    private String email;

    @Schema(description = "Areas / Zonas Hotel", example = "Hotel cityAreas")
    private String cityAreas;

    @Schema(description = "Puntos de interes Hotel", example = "Hotel poi")
    @Relationship(type = "HAS_POI")
    private List<Poi> POI;

    @Schema(description = "Habitaciones Hotel", example = "Hotel rooms")
    @Relationship(type = "HAS_ROOM")
    private List<Room> rooms;

    @Schema(description = "Precio Hotel", example = "Hotel price")
    private double price;

}
