package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

@RestController
@RequestMapping("/v1/rooms")
public class RoomRestController {

    @Autowired
    private IRoomService roomService;

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    @GetMapping("/{roomId}")
    public RoomDTO getRoomById(@PathVariable UUID id){
        return roomService.getRoomById(id);
    }

    @PutMapping("/{roomId}")
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO, @PathVariable UUID id){
        return roomService.updateRoom(roomDTO, id);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable UUID id){
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<RoomDTO> getAllRooms(){
        return roomService.getAllRooms();
    }

}