package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDTO {

    private UUID roomId;
    private List<String> amenities;
    private boolean isAvaible;
    private double price;

    
}
