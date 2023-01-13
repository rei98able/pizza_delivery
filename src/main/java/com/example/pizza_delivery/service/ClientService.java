package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.ClientEntity;

import java.util.Optional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface ClientService {
    Optional<ClientEntity> getClientById(Integer id);

    ClientEntity getClientByEmail(String phone);

    ClientEntity save(ClientEntity clientEntity);

    void delete(Integer id);
}
