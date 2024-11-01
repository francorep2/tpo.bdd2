package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO getHotelById(UUID id);

    HotelDTO updateHotel(UUID id, HotelDTO hotelDTO);

    void deleteHotel(UUID id);

    void addRoomToHotel(Long hotelId, RoomDTO roomDTO);

    void removeRoomFromHotel(Long hotelId, Long roomId);

    List<HotelDTO> getAllHotels();

    List<RoomDTO> getAllRoomsByHotelId(Long hotelId);

}