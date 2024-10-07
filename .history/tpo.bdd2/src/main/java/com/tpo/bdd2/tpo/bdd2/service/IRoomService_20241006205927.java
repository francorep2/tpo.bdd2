package com.tpo.bdd2.tpo.bdd2.service;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Room;

public interface IRoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    Room getRoomById(Long id);

    

}
