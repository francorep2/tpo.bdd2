package com.tpo.bdd2.tpo.bdd2.service;

import java.time.LocalDate;
import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO getRoomById(Long id);

    RoomDTO updateRoom(RoomDTO roomDTO, Long id);

    void deleteRoom(Long id);

    List<RoomDTO> getAllRooms();

    RoomDTO addAmenitiesToRoom(List<String> amenities, Long id);

    RoomDTO removeAmenitiesFromRoom(List<String> amenities, Long id);

    RoomDTO updateRoomAmenities(List<String> amenities, Long id);
    

    List<RoomDTO> findRoomByDateRange(LocalDate startDate, LocalDate endDate)

}
