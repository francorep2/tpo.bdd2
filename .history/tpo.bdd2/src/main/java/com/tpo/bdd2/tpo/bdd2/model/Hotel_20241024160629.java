package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
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
    private String hotelid = UUID.randomUUID().toString();

    private String name;

    @Relationship(type = "LOCATE_IN")
    private Address address;

    private List<String> phone;

    private String email;

    @Property
    private CityAreasTypes cityAreas;

    @Property
    private List<Poi> poi;

    @Relationship(type = "HAVE")
    private List<Room> rooms;

    private double price;

}