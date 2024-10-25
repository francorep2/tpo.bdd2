package com.tpo.bdd2.tpo.bdd2.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpo.bdd2.tpo.bdd2.domain.AddressDTO;
import com.tpo.bdd2.tpo.bdd2.domain.AmenitiesDTO;
import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.domain.CityAreasTypesDTO;
import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiTypesDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Address;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Poi;
import com.tpo.bdd2.tpo.bdd2.model.Room;


@Mapper(componentModel = "spring")
public interface AppMapper {

    AppMapper INSTANCE = Mappers.getMapper(AppMapper.class);

    BookingDTO bookingToBookingDTO(Booking booking);
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    HotelDTO hotelToHotelDTO(Hotel hotel);
    Hotel hotelDTOToHotel(HotelDTO hotelDTO);


    RoomDTO roomToRoomDTO(Room room);
    Room roomDTOToRoom(RoomDTO roomDTO);

    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);

    AddressDTO addressToAddressDTO(Address address);
    Address addressDTOToAddress(AddressDTO addressDTO);


    PoiDTO poiToPoiDTO(Poi poi);
    Poi poiDTOToPoi(PoiDTO poiDTO);

    List<PoiDTO> poisToPoiDTOs(List<Poi> pois);
    List<Poi> poiDTOsToPois(List<PoiDTO> poiDTOs);

    List<CityAreasTypesDTO> cityAreasTypesToCityAreasTypesDTOs(List<CityAreasTypes> cityAreasTypes);
    List<CityAreasTypes> cityAreasTypesDTOsToCityAreasTypes(List<CityAreasTypesDTO> cityAreasTypesDTOs);

    List<RoomDTO> roomsToRoomDTOs(List<Room> rooms);
    List<Room> roomDTOsToRooms(List<RoomDTO> roomDTOs);


    List<HotelDTO> hotelsToHotelDTOs(List<Hotel> hotels);
    List<Hotel> hotelDTOsToHotels(List<HotelDTO> hotelDTOs);

    List<ClientDTO> clientsToClientDTOs(List<Client> clients);
    List<Client> clientDTOsToClients(List<ClientDTO> clientDTOs);
    
}

