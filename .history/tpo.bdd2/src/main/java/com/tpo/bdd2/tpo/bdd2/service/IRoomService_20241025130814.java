package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO getRoomById(Long id);

    RoomDTO updateRoom(RoomDTO roomDTO, Long id);

    void deleteRoom(Long id);

    List<RoomDTO> getAllRooms();

    RoomDTO addAmenitiesToRoom(List<String> amenities, Long id);

}
