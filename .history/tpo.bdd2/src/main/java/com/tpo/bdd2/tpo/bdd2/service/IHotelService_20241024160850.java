package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO getHotelById(String id);

    HotelDTO updateHotel(String id, HotelDTO hotelDTO);

    void deleteHotel(String id);

    void addRoomToHotel(String hotelId, RoomDTO roomDTO);

    void removeRoomFromHotel(String hotelId, String roomId);

    List<HotelDTO> getAllHotels();

    List<RoomDTO> getAllRoomsByHotelId(String hotelId);

}
