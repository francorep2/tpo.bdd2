package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

@RestController
@RequestMapping("/v1/hotels")
public class HotelRestController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping
    public HotelDTO createHotel(@RequestBody HotelDTO hotelDTO){
        return hotelService.createHotel(hotelDTO);
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{hotelId}")
    public HotelDTO updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO){
        return hotelService.updateHotel(id, hotelDTO);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{hotelId}/rooms")
    public HotelDTO addRoomToHotel(@PathVariable Long hotelId, @RequestBody RoomDTO roomDTO){
        return hotelService.addRoomToHotel(hotelId, roomDTO);
    }

    @DeleteMapping("/{hotelId}/rooms/{roomId}")
    public ResponseEntity<void> removeRoomFromHotel(Long hotelId, Long roomId){
        
    }

    public List<Hotel> getAllHotels();

    public List<Room> getAllRoomsByHotelId(Long hotelId);

}
