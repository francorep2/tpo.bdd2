package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.Amenities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@Document(collection = "Rooms")
public class Room {

    @Id
    @Field("Room_ID")
    private String roomId;

    @Field("Amenities")
    private List<Amenities> amenities;

    @Field("isAvaible")
    private boolean isAvaible;

    @Field("Price")
    private double price;

}
