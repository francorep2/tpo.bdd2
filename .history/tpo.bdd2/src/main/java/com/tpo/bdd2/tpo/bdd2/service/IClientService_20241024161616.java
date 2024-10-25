package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;

public interface IClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO getClientById(UUID id);

    ClientDTO updateClient(UUID id, ClientDTO clientDTO);

    void deleteClient(UUID id);

    List<ClientDTO> getAllClients();

}
