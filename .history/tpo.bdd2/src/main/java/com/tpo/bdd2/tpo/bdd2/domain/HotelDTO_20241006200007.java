package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.CityAreasTypes;
import com.tpo.bdd2.tpo.bdd2.model.Poi;
import com.tpo.bdd2.tpo.bdd2.model.Room;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelDTO {

    private String id; 
    private String name;
    private Address address;
    private List<String> phone;
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
