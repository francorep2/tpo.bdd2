package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Node
@Data
@AllArgsConstructor
public class Poi {

    @Schema(description = "Poi ID ", example = "1")
    @Id
    private String poiId;

    @Schema(description = "Nombre Poi", example = "Poi 1")
    private String poiName;

    @Schema(description = "Descripcion Poi", example = "Beauty")
    private String poiDescription;

    @Schema(description = "Distancia Poi", example = "1")
    private String poiDistance;


}
