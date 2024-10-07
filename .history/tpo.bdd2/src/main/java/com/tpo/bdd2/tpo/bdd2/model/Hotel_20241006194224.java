package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.CityAreasTypes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Document(collection = "Hotels")
public class Hotel {

    @Id
    private String id; 

    @Field("name")
    private String name;

    @Field("address")
    private Address address;

    @Field("phone_number")
    private List<String> phone;

    @Field("email")
    private String email;

    @Field("city_areas")
    private CityAreasTypes cityAreas;

    @Field("point_of_interes")
    private List<Poi> poi;

    @Field("rooms")
    private List<Room> rooms;

    @Field("Price")
    private double price;

}
