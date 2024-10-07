package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDTO {

    private String roomId;
    private List<AmenitiesDTO> amenities;
    private boolean isAvaible;
    private double price;

    
}