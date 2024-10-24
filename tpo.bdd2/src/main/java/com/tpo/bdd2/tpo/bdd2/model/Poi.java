package com.tpo.bdd2.tpo.bdd2.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Node
@NoArgsConstructor
public class Poi {

    @Id
    @GeneratedValue
    private Long poiId;

    private String poiName;

}
