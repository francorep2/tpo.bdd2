package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.service.IClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService{

    @Auto

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {

        Client newClient = mapper.clientDTOToClient(clientDTO);
        Client savedBooking = bookingRepository.save(newBooking);

        log.info("Se creo la reserva " + newBooking.getBookingCode());

        return mapper.bookingToBookingDTO(savedBooking);
    }

    @Override
    public Client getClientById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientById'");
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClient'");
    }

    @Override
    public ClientDTO deleteClient(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }

    @Override
    public List<Client> getAllClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClient'");
    }

}
