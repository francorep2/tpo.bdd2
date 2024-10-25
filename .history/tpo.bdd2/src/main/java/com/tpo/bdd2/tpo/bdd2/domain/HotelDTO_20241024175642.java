package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;
import java.util.UUID;

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
    private String cityAreas;
    private List<PoiDTO> poi;
    private List<RoomDTO> rooms;
    private double price;
    
}
