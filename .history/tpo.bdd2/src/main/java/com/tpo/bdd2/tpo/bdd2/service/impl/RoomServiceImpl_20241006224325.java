package com.tpo.bdd2.tpo.bdd2.service.impl;

import org.apache.el.stream.Optional;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

public class RoomServiceImpl implements IRoomService{

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
         Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if(!hotel.isPresent()){
           throw new HotelNotFoundException("Hotel not found");
        }else{
            return hotel.get().getRooms();
        }
    }

    @Override
    public Room getRoomById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomById'");
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRoom'");
    }

    @Override
    public void deleteRoom(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRoom'");
    }

    @Override
    public Room getAllRooms() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRooms'");
    }

}
