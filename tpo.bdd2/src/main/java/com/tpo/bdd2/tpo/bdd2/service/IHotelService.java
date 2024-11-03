package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO getHotelById(String id);

    HotelDTO updateHotel(String id, HotelDTO hotelDTO);

    void deleteHotel(String id);

    void addRoomToHotel(String hotelId, String roomId);

    void removeRoomFromHotel(String hotelId, String roomId);

    void addPOIToHotel(String hotelId, PoiDTO poiDTO);

    void removePOIFromHotel(String hotelId, String poiId);

    List<HotelDTO> getAllHotels();

    List<PoiDTO> getAllPoiInHotel(String hotelId);

    List<RoomDTO> getAllRoomsByHotelId(String hotelId);

    List<HotelDTO> getAllHotelsBypoiName(String poiName);

}
