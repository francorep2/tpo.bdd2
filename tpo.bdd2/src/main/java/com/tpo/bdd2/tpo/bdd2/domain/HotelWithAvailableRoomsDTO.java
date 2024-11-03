package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelWithAvailableRoomsDTO {
    
    private HotelDTO hotel;
    private List<RoomDTO> availableRooms;


}
