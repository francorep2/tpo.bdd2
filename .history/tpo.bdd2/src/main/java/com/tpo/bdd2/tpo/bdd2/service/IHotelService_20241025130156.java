package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO getHotelById(Long id);

    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    void deleteHotel(Long id);

    void addRoomToHotel(Long hotelId, RoomDTO roomDTO);

    void removeRoomFromHotel(Long hotelId, Long roomId);

    List<HotelDTO> getAllHotels();

    List<

    List<RoomDTO> getAllRoomsByHotelId(Long hotelId);

    List<HotelDTO> getHotelsByPOI(String poiName);

}
