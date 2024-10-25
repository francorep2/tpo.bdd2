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
public class Hotel {

    @Id
    @GeneratedValue
    private UUID id; 

    private String name;

    @Relationship(type = "LOCATE_IN")
    private Address address;

    private List<String> phone;

    private String email;

    private String cityAreas;

    private List<Poi> poi;

    @Relationship(type = "HAVE")
    private List<Room> rooms;

    private double price;

}
