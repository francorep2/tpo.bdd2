package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.exception.ClientAlreadyExistsException;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.repository.ClientNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.service.IClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    private AppMapper mapper;

    @Autowired
    private ClientNeo4jRepository clientNeo4jRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Optional<Client> existingClient = clientNeo4jRepository.findById(clientDTO.getClientId());
        if (existingClient.isPresent()) {
            throw new ClientAlreadyExistsException("Client with email " + clientDTO.getEmail() + " already exists.");
        }

        Client newClient = mapper.clientDTOToClient(clientDTO);
        Client savedClient = clientNeo4jRepository.save(newClient);

        log.info("Client with id {} created successfully.", clientDTO.getClientId());
        return mapper.clientToClientDTO(savedClient);
    }

    @Override
    public ClientDTO getClientById(UUID id) {
        log.info("Client with id {} returned successfully.", id);
        return mapper.clientToClientDTO(clientNeo4jRepository.findById(id)
        .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id)));
    }

    @Override
    public ClientDTO updateClient(UUID id, ClientDTO clientDTO) {
        Optional<Client> client = clientNeo4jRepository.findById(id);  
        client.get().setName(clientDTO.getName());
        client.get().setLastName(clientDTO.getLastName());
        client.get().setEmail(clientDTO.getEmail());
        client.get().setPhone(clientDTO.getPhone());
        client.get().setAddress(clientDTO.getAddress());
        Client updatedClient = clientNeo4jRepository.save(client.get());
        log.info("Client with id {} updated successfully.", id);
        return mapper.clientToClientDTO(updatedClient);
    }

    @Override
    public void deleteClient(UUID id) {
        Optional<Client> client = clientNeo4jRepository.findById(id);  
        clientNeo4jRepository.delete(client.get());
        log.info("Client with id {} deleted successfully.", id);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return mapper.clientsToClientDTOs(clientNeo4jRepository.findAll());
    }


}