package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.neo4j.core.schema.Node;

import com.tpo.bdd2.tpo.bdd2.enums.Amenities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@Node
@NoArgsConstructor
@Document(collection = "Rooms")
public class Room {

    @Id
    @Field("Room_ID")
    private Long roomId;

    @Field("Amenities")
    private List<Amenities> amenities;

    @Field("isAvaible")
    private boolean isAvaible;

    @Field("Price")
    private double price;

}
