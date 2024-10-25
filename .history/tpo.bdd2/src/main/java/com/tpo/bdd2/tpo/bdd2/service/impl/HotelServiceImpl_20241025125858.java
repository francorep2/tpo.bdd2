package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.HotelAlreadyExistsException;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.repository.HotelNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private HotelNeo4jRepository hotelneo4jRepository; 
    
    @Autowired
    private AppMapper mapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Optional<Hotel> hotel = hotelneo4jRepository.findById(hotelDTO.getId());
        if (hotel.isPresent()) {
            throw new HotelAlreadyExistsException("Hotel already exists");
        }
        Hotel newHotel = mapper.hotelDTOToHotel(hotelDTO);
        Hotel savedHotel = hotelneo4jRepository.save(newHotel);
        log.info("Hotel with id {} created successfully.", hotelDTO.getId());
        return mapper.hotelToHotelDTO(savedHotel);
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        log.info("Hotel with id {} returned successfully.", id);
        return mapper.hotelToHotelDTO(hotelneo4jRepository.findById(id)
        .orElseThrow(() -> new HotelNotFoundException("Hotel not found")));
    }

    @Override
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        Hotel existingHotel = hotelneo4jRepository.findById(id)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        existingHotel.setName(hotelDTO.getName());
        existingHotel.setAddress(mapper.addressDTOToAddress(hotelDTO.getAddress()));
        existingHotel.setCityAreas(hotelDTO.getCityAreas());
        existingHotel.setEmail(hotelDTO.getEmail());
        existingHotel.setPhone(hotelDTO.getPhone());
        existingHotel.setPoi(mapper.poiDTOsToPois(hotelDTO.getPoi()));
        existingHotel.setPrice(hotelDTO.getPrice());
        existingHotel.setRooms(mapper.roomDTOsToRooms(hotelDTO.getRooms()));
        
        Hotel updatedHotel = hotelneo4jRepository.save(existingHotel);
        log.info("Hotel with id {} updated successfully.", hotelDTO.getId());
        return mapper.hotelToHotelDTO(updatedHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelneo4jRepository.findById(id)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
            hotelneo4jRepository.delete(hotel);
        log.info("Hotel with id {} deleted successfully.", id);
    }

    @Override
    public void addRoomToHotel(Long hotelId, RoomDTO roomDTO) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getRooms().add(mapper.roomDTOToRoom(roomDTO));
        log.info("Hotel with id {} has added room id {}",hotelId, roomDTO.getRoomId());
    }

    @Override
    public void removeRoomFromHotel(Long hotelId, Long roomId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getRooms().removeIf(room -> room.getRoomId().equals(roomId));
        log.info("Hotel with id {} has removed room id {}",hotelId, roomId);

    }

    @Override
    public List<HotelDTO> getAllHotels() {
        log.info("Returned All Hotels");
        return mapper.hotelsToHotelDTOs(hotelneo4jRepository.findAll());
    }

    @Override
    public List<RoomDTO> getAllRoomsByHotelId(Long hotelId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        log.info("Hotel with id {} returned successfully.", hotelId);
        return mapper.roomsToRoomDTOs(hotel.getRooms());
    }

    @Override
    public List<HotelDTO> getHotelsByPOI(String poiName) {
        List<Hotel> hotels = hotelneo4jRepository.findHotelsByPOI(poiName);
        
        
    }
}
