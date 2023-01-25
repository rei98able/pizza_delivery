package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.auth.security.service.RoleEntity;
import com.example.pizza_delivery.dto.ClientDTO;
import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ClientController {
    private final ClientServiceImpl clientServiceImpl;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<List<ClientEntity>> getAllClients() {
        log.info("get all clients");
        return ResponseEntity.ok(clientServiceImpl.getAllClients());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        log.info("get client by id");
        return ResponseEntity.ok(clientServiceImpl.findById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ClientEntity> createClient(@Valid @RequestBody ClientEntity clientDTO) {
        log.info("create client by admin");
        return ResponseEntity.ok(clientServiceImpl.createbyadmin(clientDTO));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@Valid @PathVariable Long id) {
        log.info("delete client");
        clientServiceImpl.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ClientEntity> update(@Valid @RequestBody ClientDTO clientDTO) {
        return clientServiceImpl.update(clientDTO);
    }

    @GetMapping("/current")
    @ResponseBody
    public ResponseEntity<ClientEntity> getCurrentUser() {
        return ResponseEntity.ok(clientServiceImpl.getCurrent());
    }
}
