package com.tpo.bdd2.tpo.bdd2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

// Definir el mapper
@Mapper
public interface AppMapper {

    AppMapper INSTANCE = Mappers.getMapper(AppMapper.class);

    // Mapeo entre Booking y BookingDTO
    BookingDTO bookingToBookingDTO(Booking booking);
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    // Mapeo entre Hotel y HotelDTO (suponiendo que tienes un HotelDTO)
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

