package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Node
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private UUID roomId;

    @Relationship(type = "HAVE")
    private List<String> amenities;

    private boolean isAvaible;
    
    private double price;

}
