package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Address;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Poi;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.AddressNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.repository.HotelNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.repository.PoiNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.repository.RoomNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private HotelNeo4jRepository hotelneo4jRepository;    
    
    @Autowired
    private AddressNeo4jRepository addressNeo4jRepository;

    @Autowired
    private PoiNeo4jRepository poiRepository;

    @Autowired
    private RoomNeo4jRepository roomRepository;
    @Autowired
    private AppMapper mapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {

        Hotel hotel = mapper.hotelDTOToHotel(hotelDTO);
        hotelneo4jRepository.save(hotel);
        log.info("Hotel with id {} created successfully.", hotelDTO.getId());
        return mapper.hotelToHotelDTO(hotel);
    }


    @Override
    public HotelDTO getHotelById(String id) {
        log.info("Hotel with id {} returned successfully.", id);
        return mapper.hotelToHotelDTO(hotelneo4jRepository.findById(id)
        .orElseThrow(() -> new HotelNotFoundException("Hotel not found")));
    }

    @Override
    public HotelDTO updateHotel(String id, HotelDTO hotelDTO) {
        Hotel existingHotel = hotelneo4jRepository.findById(id)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        existingHotel.setName(hotelDTO.getName());
        existingHotel.setAddress(mapper.addressDTOToAddress(hotelDTO.getAddress()));
        existingHotel.setCityAreas(hotelDTO.getCityAreas());
        existingHotel.setEmail(hotelDTO.getEmail());
        existingHotel.setPhone(hotelDTO.getPhone());
        existingHotel.setPOI(mapper.poiDTOsToPois(hotelDTO.getPOI()));
        existingHotel.setPrice(hotelDTO.getPrice());
        existingHotel.setRooms(mapper.roomDTOsToRooms(hotelDTO.getRooms()));
        
        Hotel updatedHotel = hotelneo4jRepository.save(existingHotel);
        log.info("Hotel with id {} updated successfully.", hotelDTO.getId());
        return mapper.hotelToHotelDTO(updatedHotel);
    }

    @Override
    public void deleteHotel(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Hotel ID cannot be null or empty.");
        }

        Hotel hotel = hotelneo4jRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with ID: " + id));

        List<Room> rooms = hotel.getRooms();
        if (rooms != null) {
            for (Room room : rooms) {
                roomRepository.delete(room); 
            }
        }

        List<Poi> pois = hotel.getPOI(); 
        if (pois != null) {
            for (Poi poi : pois) {
                poiRepository.delete(poi); 
            }
        }

        Address address = hotel.getAddress(); 
        if (address != null) {
            addressNeo4jRepository.delete(address); 
        }

        hotelneo4jRepository.delete(hotel);

        log.info("Hotel with id {} and its associated rooms, pois, and address deleted successfully.", id);
    }


    @Override
    public void addRoomToHotel(String hotelId, RoomDTO roomDTO) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getRooms().add(mapper.roomDTOToRoom(roomDTO));
        log.info("Hotel with id {} has added room id {}",hotelId, roomDTO.getRoomId());
    }

    @Override
    public void removeRoomFromHotel(String hotelId, String roomId) {
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
    public List<RoomDTO> getAllRoomsByHotelId(String hotelId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        log.info("Hotel with id {} returned successfully.", hotelId);
       return mapper.roomsToRoomDTOs(hotel.getRooms());
    }

    @Override
    public List<HotelDTO> getHotelsByPOI(String poiName) {
        List<Hotel> hotels = hotelneo4jRepository.findHotelsByPOI(poiName);
        return mapper.hotelsToHotelDTOs(hotels);
        
    }

    @Override
    public List<PoiDTO> getAllPoiInHotel(String hotelId) { 
        List<PoiDTO> pois = hotelneo4jRepository.getAllPOISinHotelByid(hotelId);
        log.info("Hotel with id {} returned successfully.", hotelId);
        return pois;
    }

    @Override
    public void addPOIToHotel(String hotelId, PoiDTO poiDTO) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getPOI().add(mapper.poiDTOToPoi(poiDTO));
        log.info("Hotel with id {} has added poi id {}", hotelId, poiDTO.getPoiId());
    }

    @Override
    public void removePOIFromHotel(String hotelId, String poiId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getPOI().removeIf(poi -> poi.getPoiId().equals(poiId));
        log.info("Hotel with id {} has removed poi id {}", hotelId, poiId);
    }
}
