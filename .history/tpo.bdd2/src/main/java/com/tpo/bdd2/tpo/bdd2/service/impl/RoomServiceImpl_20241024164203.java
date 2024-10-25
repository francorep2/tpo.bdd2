package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.RoomNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.RoomNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomNeo4jRepository roomNeo4jRepository;

    @Autowired
    private AppMapper mapper;

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room newRoom = mapper.roomDTOToRoom(roomDTO);
        Room savedRoom = roomNeo4jRepository.save(newRoom);
        return mapper.roomToRoomDTO(savedRoom);
    }

    @Override
    public RoomDTO getRoomById(UUID id) {
        return mapper.roomToRoomDTO(roomNeo4jRepository.findById(id)
        .orElseThrow(() -> new RoomNotFoundException("Room not found")));
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO, UUID id) {
        Room updatedRoom = roomNeo4jRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));
        
        updatedRoom.setAmenities(roomDTO.getAmenities());
        roomNeo4jRepository.save(updatedRoom);
        return mapper.roomToRoomDTO(updatedRoom);
    }

    @Override
    public void deleteRoom(UUID id) {
        Room room = roomNeo4jRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));
            roomNeo4jRepository.delete(room);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomNeo4jRepository.findAll()
            .stream()
            .map(mapper::roomToRoomDTO)
            .collect(Collectors.toList());
    }
}
