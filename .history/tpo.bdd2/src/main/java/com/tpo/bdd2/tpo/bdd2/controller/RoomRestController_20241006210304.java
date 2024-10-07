package com.tpo.bdd2.tpo.bdd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    public Room getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO, @PathVariable Long id){
        return roomService.updateRoom(roomDTO, id);
    }

    public ResponseEntity<Void> deleteRoom(@ReLong id){
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    public Room getAllRooms();

}
