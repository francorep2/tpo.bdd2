package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{clientId}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    List<Client> getAllClient(){
        return clientService.getAllClient();
    }

}
