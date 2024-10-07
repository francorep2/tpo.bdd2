package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService{
    
    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createHotel'");
    }

    @Override
    public Hotel getHotelById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHotelById'");
    }

    @Override
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateHotel'");
    }

    @Override
    public void deleteHotel(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteHotel'");
    }

    @Override
    public void addRoomToHotel(Long hotelId, RoomDTO roomDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRoomToHotel'");
    }

    @Override
    public void removeRoomFromHotel(Long hotelId, Long roomId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeRoomFromHotel'");
    }

    @Override
    public List<Hotel> getAllHotels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllHotels'");
    }

    @Override
    public List<Room> getAllRoomsByHotelId(Long hotelId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRoomsByHotelId'");
    }


}
