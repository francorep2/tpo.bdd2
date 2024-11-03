package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.HotelWithAvailableRoomsDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.exception.RoomNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.HotelNeo4jRepository;
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

    @Autowired
    private HotelNeo4jRepository hotelNeo4jRepository;

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room newRoom = mapper.roomDTOToRoom(roomDTO);
        Room savedRoom = roomNeo4jRepository.save(newRoom);
        return mapper.roomToRoomDTO(savedRoom);
    }

    @Override
    public RoomDTO getRoomById(String id) {
        return mapper.roomToRoomDTO(roomNeo4jRepository.findById(id)
        .orElseThrow(() -> new RoomNotFoundException("Room not found")));
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO, String id) {
        Room updatedRoom = roomNeo4jRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));
        
        updatedRoom.setAmenities(roomDTO.getAmenities());
        roomNeo4jRepository.save(updatedRoom);
        return mapper.roomToRoomDTO(updatedRoom);
    }

    @Override
    public void deleteRoom(String id) {
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

    @Override
    public RoomDTO addAmenitiesToRoom(List<String> amenities, String id) {
        Room room = roomNeo4jRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));


        room.getAmenities().addAll(amenities);
        Room updatedRoom = roomNeo4jRepository.save(room);
        return mapper.roomToRoomDTO(updatedRoom);
        
    }

    @Override
    public RoomDTO removeAmenitiesFromRoom(List<String> amenities, String id) {
        Room room = roomNeo4jRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));

        room.getAmenities().removeAll(amenities);
        Room updatedRoom = roomNeo4jRepository.save(room);
        return mapper.roomToRoomDTO(updatedRoom);
    }

    @Override
    public HotelWithAvailableRoomsDTO findRoomByDateRange(LocalDate startDate, LocalDate endDate, String hotelId) {
        Hotel hotel = hotelNeo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
    
        List<Room> rooms = hotel.getRooms();
    
        List<Room> availableRooms = rooms.stream()
            .filter(room -> isRoomAvailable(room, startDate, endDate))
            .collect(Collectors.toList());
    
        HotelDTO hotelDTO = mapper.toHotelDTO(hotel);
    
        HotelWithAvailableRoomsDTO response = new HotelWithAvailableRoomsDTO();
        response.setHotel(hotelDTO);
        response.setAvailableRooms(availableRooms.stream()
            .map(mapper::roomToRoomDTO)
            .collect(Collectors.toList()));
    
        return response;
    }
    
    private boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        if (Boolean.FALSE.equals(room.getIsAvailable())) {
            return false; 
        }
    
        LocalDate availableFrom = room.getAvailableFrom();
        LocalDate availableUntil = room.getAvailableUntil();
    
        return (availableFrom.isBefore(endDate) || availableFrom.isEqual(endDate)) &&
            (availableUntil.isAfter(startDate) || availableUntil.isEqual(startDate));
    }

    @Override
    public List<String> getAllAmenitiesByRoomId(String id) {
        Room room = roomNeo4jRepository.findById(id)
            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));

        return room.getAmenities();
    }
}
