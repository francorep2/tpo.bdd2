package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.exception.RoomNotFoundException;
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

    @Autowired
    private Neo4jClient neo4jClient;


    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        

        Hotel hotel = mapper.toHotel(hotelDTO);
        hotelneo4jRepository.save(hotel);
        log.info("Hotel with id {} created successfully.", hotelDTO.getId());
        return mapper.toHotelDTO(hotel);
    }


    @Override
    public HotelDTO getHotelById(String id) {
        log.info("Hotel with id {} returned successfully.", id);
        return mapper.toHotelDTO(hotelneo4jRepository.findById(id)
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
        existingHotel.setPois(mapper.poisDTOToPois(hotelDTO.getPois()));
        existingHotel.setPrice(hotelDTO.getPrice());
        existingHotel.setRooms(mapper.roomDTOsToRooms(hotelDTO.getRooms()));
        
        Hotel updatedHotel = hotelneo4jRepository.save(existingHotel);
        log.info("Hotel with id {} updated successfully.", hotelDTO.getId());
        return mapper.toHotelDTO(updatedHotel);
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

        List<Poi> pois = hotel.getPois(); 
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
    public void addRoomToHotel(String hotelId, String roomId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new RoomNotFoundException("Room not found"));

        hotel.getRooms().add(room);
        hotelneo4jRepository.save(hotel);
        log.info("Hotel with id {} has added room id {}",hotelId, roomId);
    }

@Override
public void removeRoomFromHotel(String hotelId, String roomId) {
    Hotel hotel = hotelneo4jRepository.findById(hotelId)
        .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

    List<Room> rooms = hotel.getRooms();
    Room roomToRemove = null;

    for (Room r : rooms) {
        if (r.getRoomId().equals(roomId)) {
            roomToRemove = r;
            break; 
        }
    }
    if (roomToRemove != null) {
        rooms.remove(roomToRemove); 
        hotelneo4jRepository.save(hotel); 
        roomRepository.delete(roomToRemove); 
        log.info("Hotel with id {} has removed room id {}", hotelId, roomId);
    } else {
        throw new RoomNotFoundException("Room not found in the hotel");
    }
}


    @Override
    public List<HotelDTO> getAllHotels() {
        log.info("Returned All Hotels");
        return mapper.toHotelDTOs(hotelneo4jRepository.findAll());
    }

    @Override
    public List<RoomDTO> getAllRoomsByHotelId(String hotelId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        log.info("Hotel with id {} returned successfully.", hotelId);
       return mapper.roomsToRoomDTOs(hotel.getRooms());
    }

    @Override
    @Transactional(readOnly = true)
    public List<HotelDTO> getAllHotelsBypoiName(String poiName) {
        List<String> hotelsId = hotelneo4jRepository.getAllHotelsIDByPoiName(poiName);
        List<Hotel> hotels = hotelneo4jRepository.findAllById(hotelsId);
        return mapper.toHotelDTOs(hotels);
    }
    

    @Override
    public List<PoiDTO> getAllPoiInHotel(String hotelId) { 
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        return mapper.poisToPoisDTO(hotel.getPois());
    }

    @Override
    public void addPOIToHotel(String hotelId, PoiDTO poiDTO) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotel.getPois().add(mapper.poiDTOToPoi(poiDTO));
        hotelneo4jRepository.save(hotel);

        log.info("Hotel with id {} has added poi id {}", hotelId, poiDTO.getPoiId());
    }

    @Override
    public void removePOIFromHotel(String hotelId, String poiId) {
        Hotel hotel = hotelneo4jRepository.findById(hotelId)
            .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
            List<Poi> pois = hotel.getPois();
            Poi poiToRemove = null; 
        
            for (Poi p : pois) {
                if (p.getPoiId().equals(poiId)) {
                    poiToRemove = p;
                    break;
                }
            } 

            if (poiToRemove != null) {
                pois.remove(poiToRemove); 
                hotelneo4jRepository.save(hotel); 
                poiRepository.delete(poiToRemove); 
                log.info("Hotel with id {} has removed room id {}", hotelId, poiId);
            } else {
                throw new RoomNotFoundException("Room not found in the hotel");
            }

        log.info("Hotel with id {} has removed poi id {}", hotelId, poiId);
    }
}
