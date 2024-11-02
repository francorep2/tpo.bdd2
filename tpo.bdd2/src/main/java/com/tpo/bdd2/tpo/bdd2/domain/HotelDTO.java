package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelDTO {

    private String id; 
    private String name;
    private AddressDTO address;
    private List<String> phone;
    private String email;
    private String cityAreas;
    private List<PoiDTO> POI;
    private List<RoomDTO> rooms;
    private double price;
    
}
