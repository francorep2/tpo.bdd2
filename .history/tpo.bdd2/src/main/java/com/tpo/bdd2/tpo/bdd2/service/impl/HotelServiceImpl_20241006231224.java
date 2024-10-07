package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.repository.mongo.HotelRepository;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private final HotelRepository hotelRepository; 
    
    @Autowired
    private final AppMapper mapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelDTO.getId());
        if (hotel.isPresent()) {
            throw new HotelNotFoundException("Hotel already exists");
        }
        Hotel newHotel = mapper.hotelDTOToHotel(hotelDTO);
        Hotel savedHotel = hotelRepository.save(newHotel);
        log.info("Hotel with id {} created successfully.", hotelDTO.getId());
        return mapper.hotelToHotelDTO(savedHotel);
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        log.info("Hotel with id {} returned successfully.", id);
        return mapper.hotelToHotelDTO(hotelRepository.findById(id)
        .orElseThrow(() -> new HotelNotFoundException("Hotel not found")));
    }

    @Override
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        Hotel existingHotel = hotelRepository.findById(id)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        existingHotel.setName(hotelDTO.getName());
        existingHotel.setAddress(mapper.addressDTOToAddress(hotelDTO.getAddress()));
        existingHotel.setCityAreas(mapper.cityAreasTypesDTOToCityAreasTypes(hotelDTO.getCityAreas()));
        existingHotel.setEmail(hotelDTO.getEmail());
        existingHotel.setPhone(hotelDTO.getPhone());
        existingHotel.setPoi(mapper.poiDTOsToPois(hotelDTO.getPoi()));
        existingHotel.setPrice(hotelDTO.getPrice());
        existingHotel.setRooms(mapper.roomDTOsToRooms(hotelDTO.getRooms()));
        
        Hotel updatedHotel = hotelRepository.save(existingHotel);
        log.info("Hotel with id {} updated successfully.", hotelDTO.getId());
        return mapper.hotelToHotelDTO(updatedHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        hotelRepository.delete(hotel);
        log.info("Hotel with id {} deleted successfully.", id);
    }

    @Override
    public void addRoomToHotel(Long hotelId, RoomDTO roomDTO) {
        Hotel hotel = hotelRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getRooms().add(mapper.roomDTOToRoom(roomDTO));
        log.info("Hotel with id {} ha");
    }

    @Override
    public void removeRoomFromHotel(Long hotelId, Long roomId) {
        Hotel hotel = hotelRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getRooms().removeIf(room -> room.getRoomId().equals(roomId));
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return mapper.hotelsToHotelDTOs(hotelRepository.findAll());
    }

    @Override
    public List<RoomDTO> getAllRoomsByHotelId(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        return mapper.roomsToRoomDTOs(hotel.getRooms());
    }
}
