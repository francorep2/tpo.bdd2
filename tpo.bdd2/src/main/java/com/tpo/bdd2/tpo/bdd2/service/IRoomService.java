package com.tpo.bdd2.tpo.bdd2.service;

import java.time.LocalDate;
import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.HotelWithAvailableRoomsDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO getRoomById(String id);

    RoomDTO updateRoom(RoomDTO roomDTO, String id);

    void deleteRoom(String id);

    List<RoomDTO> getAllRooms();

    RoomDTO addAmenitiesToRoom(List<String> amenities, String id);

    RoomDTO removeAmenitiesFromRoom(List<String> amenities, String id);

    List<String> getAllAmenitiesByRoomId(String id);

    HotelWithAvailableRoomsDTO findRoomByDateRange(LocalDate startDate, LocalDate endDate, String hotelId);

}
