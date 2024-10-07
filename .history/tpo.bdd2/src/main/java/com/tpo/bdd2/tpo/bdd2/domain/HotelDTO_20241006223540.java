package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.model.Poi;
import com.tpo.bdd2.tpo.bdd2.model.Room;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelDTO {

    private Long id; 
    private String name;
    private AddressDTO address;
    private List<String> phone;
    private String email;
    private CityAreasTypesDTO cityAreas;
    private List<PoiDTO> poi;
    private List<Room> rooms;
    private double price;
    
}