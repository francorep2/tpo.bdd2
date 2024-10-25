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

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
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
    public HotelDTO getHotelById(@PathVariable Long id){
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
    public  ResponseEntity<Void> addRoomToHotel(@PathVariable Long hotelId, @RequestBody RoomDTO roomDTO){
        hotelService.addRoomToHotel(hotelId, roomDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Void> removeRoomFromHotel(@PathVariable Long hotelId, @PathVariable Long roomId){
        hotelService.removeRoomFromHotel(hotelId, roomId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<HotelDTO> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}/rooms")
    public List<RoomDTO> getAllRoomsByHotelId(@PathVariable Long hotelId){
        return hotelService.getAllRoomsByHotelId(hotelId);
    }

    @GetMapping("/{poiname}")
    public List<HotelDTO> getHotelsByPOI(@PathVariable String poiname){
        return hotelService.getHotelsByPOI(poiname);
    }

}
