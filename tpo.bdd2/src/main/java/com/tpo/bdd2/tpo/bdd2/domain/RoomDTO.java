package com.tpo.bdd2.tpo.bdd2.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDTO {

    private String roomId;
    private List<String> amenities;
    private boolean isAvailable;
    private double price;
    private LocalDate availableFrom;
    private LocalDate availableUntil;

    
}
