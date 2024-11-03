package com.tpo.bdd2.tpo.bdd2.mapper;

import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;

import com.tpo.bdd2.tpo.bdd2.domain.AddressDTO;
import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Address;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Poi;
import com.tpo.bdd2.tpo.bdd2.model.Room;


@Mapper(componentModel = "spring")
public interface AppMapper {

    BookingDTO bookingToBookingDTO(Booking booking);
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    HotelDTO toHotelDTO(Hotel hotel);
    Hotel toHotel(HotelDTO hotelDTO);

    RoomDTO roomToRoomDTO(Room room);
    Room roomDTOToRoom(RoomDTO roomDTO);

    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);

    AddressDTO addressToAddressDTO(Address address);
    Address addressDTOToAddress(AddressDTO addressDTO);

    PoiDTO poiToPoiDTO(Poi poi);
    Poi poiDTOToPoi(PoiDTO poiDTO);

    List<PoiDTO> poisToPoisDTO(List<Poi> pois);
    List<Poi> poisDTOToPois(List<PoiDTO> poiDTOs);

    List<RoomDTO> roomsToRoomDTOs(List<Room> rooms);
    List<Room> roomDTOsToRooms(List<RoomDTO> roomDTOs);

    List<BookingDTO> bookingsToBookingDTOs(List<Booking> bookings);
    List<Booking> bookingDTOsToBookings(List<BookingDTO> bookingDTOs);

    List<HotelDTO> toHotelDTOs(List<Hotel> hotels);
    List<Hotel> toHotels(List<HotelDTO> hotelDTOs);

    List<ClientDTO> clientsToClientDTOs(List<Client> clients);
    List<Client> clientDTOsToClients(List<ClientDTO> clientDTOs);
    
}

