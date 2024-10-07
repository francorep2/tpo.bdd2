package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    ClientDTO createClient(@RequestBody ClientDTO clientDTO){
        return clientService.createClient(clientDTO);
    }

    @GetMapping("/{clientId}")
    Client getClientById(Long id){
        return clientService.getClientById(id);
    }

    
    ClientDTO updateClient(Long id, ClientDTO clientDTO){
        return clientService.updateClient(id, clientDTO);
    }

    ClientDTO deleteClient(Long id){
        return clientService.deleteClient(id);
    }

    @GetMapping
    List<Client> getAllClient(){
        return clientService.getAllClient();
    }

}
