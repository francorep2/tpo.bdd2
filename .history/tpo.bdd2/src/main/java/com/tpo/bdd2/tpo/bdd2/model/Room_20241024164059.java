package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private UUID roomId;
    
    private List<String> amenities;
    private boolean isAvaible;
    private double price;

    
}
