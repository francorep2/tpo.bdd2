package com.tpo.bdd2.tpo.bdd2.service.impl;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.RoomNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.mongo.RoomRepository;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

public class RoomServiceImpl implements IRoomService{

    @Autowired
    private final RoomRepository roomRepository;

    @Autowired
    private final AppMapper mapper;

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
         Optional<Room> room = roomRepository.findById(roomDTO.getRoomId());
        if(!room.isPresent()){
           throw new RoomNotFoundException("Room not found");
        }else{

            Hotel newHotel = mapper.hotelDTOToHotel(hotelDTO);
            Hotel savedHotel = hotelRepository.save(newHotel);
            return mapper.hotelToHotelDTO(savedHotel);
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
