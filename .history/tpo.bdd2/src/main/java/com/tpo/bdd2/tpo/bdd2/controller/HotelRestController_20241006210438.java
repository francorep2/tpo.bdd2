package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

        HotelDTO createHotel(HotelDTO hotelDTO);

    Hotel getHotelById(Long id);

    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    HotelDTO deleteHotel(Long id);

    HotelDTO addRoomToHotel(Long hotelId, RoomDTO roomDTO);

    HotelDTO removeRoomFromHotel(Long hotelId, Long roomId);

    List<Hotel> getAllHotels();

    List<Room> getAllRoomsByHotelId(Long hotelId);

}
