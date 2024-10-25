package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Node
@NoArgsConstructor
public class Poi {

    @Schema(description = "Poi ID ", example = "1")
    @Id
    private Long id;

    @Schema(description = "Nombre Poi", example = "Poi 1")
    private String poiName;

}
