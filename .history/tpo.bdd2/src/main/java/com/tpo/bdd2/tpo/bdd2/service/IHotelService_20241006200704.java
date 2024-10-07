package com.tpo.bdd2.tpo.bdd2.service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;

public interface IHotelService {

    HotelDTO createHotel(HotelDTO hotelDTO, RoomDTO roomDTO);

    HotelDTO getHotelById(Long id);

    HotelDTO 

}
