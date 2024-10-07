package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.ClientDTO;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.service.IClientService;

@RestController
@RequestMapping("/v1/clients")
public class ClientRestController {

    @Autowired
    private IClientService clientService;

    ClientDTO createClient(ClientDTO clientDTO){
        return clientService.createClient(clientDTO);
    }

    Client getClientById(Long id){
        return clientService.getClientById(id);
    }

    ClientDTO updateClient(Long id, ClientDTO clientDTO);

    ClientDTO deleteClient(Long id);

    List<Client> getAllClient();

}
