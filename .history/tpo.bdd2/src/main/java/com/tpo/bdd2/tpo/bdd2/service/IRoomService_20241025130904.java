package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import java.time.LocalDate;
import java.time.LocalDate;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO getRoomById(Long id);

    RoomDTO updateRoom(RoomDTO roomDTO, Long id);

    void deleteRoom(Long id);

    List<RoomDTO> getAllRooms();

    RoomDTO addAmenitiesToRoom(List<String> amenities, Long id);

    RoomDTO removeAmenitiesFromRoom(List<String> amenities, Long id);

    RoomDTO updateRoomAmenities(List<String> amenities, Long id);

    List<RoomDTO findRoomByDateRange(LocalDate startDate, LocalDate endDate)

}
