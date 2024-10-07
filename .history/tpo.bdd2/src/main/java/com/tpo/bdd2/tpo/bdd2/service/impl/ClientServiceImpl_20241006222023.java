package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.repository.mongo.ClientRepository;
import com.tpo.bdd2.tpo.bdd2.service.IClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService{

    @Autowired
    private final AppMapper mapper;

    @Autowired
    private final ClientRepository clientRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {

        Client newClient = mapper.clientDTOToClient(clientDTO);
        Client savedClient = clientRepository.save(newClient);

        log.info("Se creo el cliente " + newClient.getName() + " " + newClient.getLastName());

        return mapper.clientToClientDTO(savedClient);
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            return clientOptional.get(); 
        }else{
            throw new ClientNotFoundException("Client not found with id: " + id);
        }
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
        .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));

            client.setName(clientDTO.getName());
            client.setLastName(clientDTO.getLastName());
            client.setEmail(clientDTO.getEmail());
            client.setPhone(clientDTO.getPhone());
            client.setAddress(clientDTO.getAddress());
            Client updatedClient = clientRepository.save(client);
            return mapper.clientToClientDTO(updatedClient);
        }

    @Override
    public ClientDTO deleteClient(Long id) {
        Client client = clientRepository.findById(id)
        .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));
        clientRepository.delete(client);

        log.info("Client with id {} deleted successfully.", id);
}
    }

    @Override
    public List<Client> getAllClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClient'");
    }

}
