package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Node
@NoArgsConstructor
public class Hotel {

    @Schema(description = "Hotel ID ", example = "1")
    @Id
    @GeneratedValue
    private Long id; 

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

    @Relationship(type = "HAS_POI")
    private List<Poi> poi;

    @Relationship(type = "HAVE")
    private List<Room> rooms;

    private double price;

}
