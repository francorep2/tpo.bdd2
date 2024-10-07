package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public HotelDTO createHotel(@RequestBody HotelDTO hotelDTO);

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(Long id);

    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    public HotelDTO deleteHotel(Long id);

    public HotelDTO addRoomToHotel(Long hotelId, RoomDTO roomDTO);

    public HotelDTO removeRoomFromHotel(Long hotelId, Long roomId);

    public List<Hotel> getAllHotels();

    public List<Room> getAllRoomsByHotelId(Long hotelId);

}
