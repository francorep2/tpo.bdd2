package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.model.Client;

public interface IClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO getClientById(Long id);

    ClientDTO updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);

    List<Client> getAllClient();

}
