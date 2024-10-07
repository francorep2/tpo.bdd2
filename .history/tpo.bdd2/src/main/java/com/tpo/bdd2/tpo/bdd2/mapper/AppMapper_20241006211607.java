package com.tpo.bdd2.tpo.bdd2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpo.bdd2.tpo.bdd2.domain.AddressDTO;
import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Address;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;

// Definir el mapper
@Mapper
public interface AppMapper {

    AppMapper INSTANCE = Mappers.getMapper(AppMapper.class);

    BookingDTO bookingToBookingDTO(Booking booking);
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    HotelDTO hotelToHotelDTO(Hotel hotel);
    Hotel hotelDTOToHotel(HotelDTO hotelDTO);

    // Mapeo entre Room y RoomDTO (suponiendo que tienes un RoomDTO)
    RoomDTO roomToRoomDTO(Room room);
    Room roomDTOToRoom(RoomDTO roomDTO);

    // Mapeo entre Client y ClientDTO (suponiendo que tienes un ClientDTO)
    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);

    // Mapeo entre Address y AddressDTO (suponiendo que tienes un AddressDTO)
    AddressDTO addressToAddressDTO(Address address);
    Address addressDTOToAddress(AddressDTO addressDTO);
}

