package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.ClientService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */

@RestController
@Api(value = "ClientController", description = "REST APIs related to Client Entity")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @PostMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientEntity> createClient(@RequestBody ClientEntity clientEntity) {
        return ResponseEntity.ok(
                clientService.save(clientEntity)
        );
    }

    @GetMapping("/client/all")
    public List<ClientEntity> getAllClient() {
        return clientService.getAllClients();
    }

    @PutMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientEntity> updateClient(@PathVariable Integer id, @RequestBody ClientEntity clientEntity) {
        return ResponseEntity.ok(
                clientService.save(clientEntity)
        );
    }

    @DeleteMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
    }
}
