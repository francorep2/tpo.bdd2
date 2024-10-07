package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;


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
public class RoomServiceImpl implements IRoomService {

    private final RoomRepository roomRepository;
    private final AppMapper mapper;

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room newRoom = mapper.roomDTOToRoom(roomDTO);
        Room savedRoom = roomRepository.save(newRoom);
        return mapper.roomToRoomDTO(savedRoom);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO, Long id) {
        Room updatedRoom = roomRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));
        
        updatedRoom.setAmenities(mapper.AmenitiesDTOToAmenities(roomDTO.getAmenities()));
        roomRepository.save(updatedRoom);
        return mapper.roomToRoomDTO(updatedRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));
        roomRepository.delete(room);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll()
            .stream()
            .map(mapper::roomToRoomDTO)
            .collect(Collectors.toList());
    }
}
