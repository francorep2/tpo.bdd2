package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;

public interface IClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO getClientById(Long id);

    ClientDTO updateClient(String id, ClientDTO clientDTO);

    void deleteClient(String id);

    List<ClientDTO> getAllClients();

}
