package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.mongo.HotelRepository;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private final HotelRepository hotelRepository; 

    @Autowired
    private final AppMapper mapper;
    
    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
         Optional<Hotel> hotel = hotelRepository.findById(hotelDTO.getId());
         if(hotel != null){
            throw new HotelNotFoundException("Hotel already exists");
         }
         Hotel newHotel = mapper.toHotel(hotelDTO);
         Hotel savedHotel = hotelRepository.save(newHotel);
         
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
