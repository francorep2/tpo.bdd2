package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.RoomNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.mongo.RoomRepository;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
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
            Room newRoom = mapper.roomDTOToRoom(roomDTO);
            Room savedRoom = roomRepository.save(newRoom);
            return mapper.roomToRoomDTO(savedRoom);
        }
    }

    @Override
    public Room getRoomById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if(!room.isPresent()){
           throw new RoomNotFoundException("Room not found");
        }else{
            return room.get();
        }
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO, Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (!room.isPresent()) {
            throw new RoomNotFoundException("Room not found with id: " + id);
        }
        
        Room updatedRoom = room.get();
        
        updatedRoom.setAmenities(mapper.AmenitiesDTOToAmenities(roomDTO.getAmenities()));

    
        roomRepository.save(updatedRoom);
        return mapper.roomToRoomDTO(updatedRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (!room.isPresent()) {
            throw new RoomNotFoundException("Room not found with id: " + id);
        }
    }

    @Override
    public Room getAllRooms() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRooms'");
    }

}
