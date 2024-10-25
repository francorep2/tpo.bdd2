package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.tpo.bdd2.tpo.bdd2.enums.CityAreasTypes;

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
    private Long id; 

    private String name;

    @Relationship(type = "LOCATE_IN")
    private Address address;

    private List<String> phone;

    private String email;

    private CityAreasTypes cityAreas;

    private List<Poi> poi;

    @Relationship(type = "HAVE")
    private List<Room> rooms;

    private double price;

}
