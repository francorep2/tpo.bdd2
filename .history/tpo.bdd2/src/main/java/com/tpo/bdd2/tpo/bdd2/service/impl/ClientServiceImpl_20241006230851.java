package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.exception.ClientAlreadyExistsException;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
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
        Optional<Client> existingClient = clientRepository.findById(clientDTO.getClientId());
        if (existingClient.isPresent()) {
            throw new ClientAlreadyExistsException("Client with email " + clientDTO.getEmail() + " already exists.");
        }

        Client newClient = mapper.clientDTOToClient(clientDTO);
        Client savedClient = clientRepository.save(newClient);

        log.info("Se creó el cliente " + newClient.getName() + " " + newClient.getLastName());
        return mapper.clientToClientDTO(savedClient);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return mapper.clientToClientDTO(clientRepository.findById(id)
        .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id)));
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Optional<Client> client = clientRepository.findById(id);  
        client.get().setName(clientDTO.getName());
        client.get().setLastName(clientDTO.getLastName());
        client.get().setEmail(clientDTO.getEmail());
        client.get().setPhone(clientDTO.getPhone());
        client.get().setAddress(clientDTO.getAddress());
        Client updatedClient = clientRepository.save(client.get());
        return mapper.clientToClientDTO(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = getClientById(id);  
        clientRepository.delete(client);
        log.info("Client with id {} deleted successfully.", id);
    }

    @Override
    public List<ClientDTO> getAllClient() {
        return mapper.clientsToClientDTOs(clientRepository.findAll());
    }

    @Override
    public List<ClientDTO> getAllClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClient'");
    }
}