package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;
import java.util.UUID;

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
import com.tpo.bdd2.tpo.bdd2.service.IClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/v1/clients")
public class ClientRestController {

    @Autowired
    private IClientService clientService;
    
    @Operation(summary = "Crear nuevo cliente")
    @ApiResponse(responseCode = "201", description = "Cliente creado")
    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO){
        return clientService.createClient(clientDTO);
    }

    @Operation(summary = "Obtener cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado")
    @GetMapping("/{clientId}")
    public ClientDTO getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @Operation(summary = "Actualizar cliente")
    @ApiResponse(responseCode = "200", description = "Cliente actualizado")
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
    List<ClientDTO> getAllClient(){
        return clientService.getAllClients();
    }

}
