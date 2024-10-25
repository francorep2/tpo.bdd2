package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO getRoomById(UUID id);

    RoomDTO updateRoom(RoomDTO roomDTO, UUID id);

    void deleteRoom(Long id);
    UUID
    List<RoomDTO> getAllRooms();

}
