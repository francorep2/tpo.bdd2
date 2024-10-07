package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    Hotel getHotelById(Long id);

    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    void deleteHotel(Long id);

    HotelDTO addRoomToHotel(Long hotelId, RoomDTO roomDTO);

    HotelDTO removeRoomFromHotel(Long hotelId, Long roomId);

    List<Hotel> getAllHotels();

    List<Room> getAllRoomsByHotelId(Long hotelId);

}
