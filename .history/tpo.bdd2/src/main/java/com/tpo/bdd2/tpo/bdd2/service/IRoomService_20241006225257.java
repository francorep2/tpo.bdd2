package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Room;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    Room getRoomById(Long id);

    RoomDTO updateRoom(RoomDTO roomDTO, Long id);

    void deleteRoom(Long id);

    List<Room> getAllRooms();

}
