package com.tpo.bdd2.tpo.bdd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

@RestController
@RequestMapping("/v1/rooms")
public class RoomRestController {

    @Autowired
    private IRoomService roomService;

    public RoomDTO createRoom(RoomDTO roomDTO){
        
    }

    public Room getRoomById(Long id);

    public RoomDTO updateRoom(RoomDTO roomDTO, Long id);

    public RoomDTO deleteRoom(Long id);

    public Room getAllRooms();

}
