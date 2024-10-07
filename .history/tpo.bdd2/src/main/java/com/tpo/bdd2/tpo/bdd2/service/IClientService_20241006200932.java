package com.tpo.bdd2.tpo.bdd2.service;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.model.Client;

public interface IClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO getClientById(Long id);

    ClientDTO updateClient(Long id, ClientDTO clientDTO);

    ClientDTO deleteClient(Long id);

    ClientDTO

}
