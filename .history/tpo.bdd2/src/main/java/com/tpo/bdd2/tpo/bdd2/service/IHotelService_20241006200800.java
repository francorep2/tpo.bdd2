package com.tpo.bdd2.tpo.bdd2.service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO getHotelById(Long id);

    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    HotelDTO deleteHotel(Long id);

    HotelDTO addRoomToHotel(Long hotelId, RoomDTO roomDTO);

    HotelDTO removeRoomFromHotel(Long hotelId, Long roomId);


}
