package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.ClientEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface ClientService {

    ClientEntity getClientByEmail(String phone);

    ClientEntity save(ClientEntity clientEntity);

    void delete(Long id);
    void deleteByLogin(String login);

    List<ClientEntity> getAllClients();

    ClientEntity findByLogin(String userLogin);

    ClientEntity findByEmail(String email);

    Boolean exist(String login, String email);

    ClientEntity getCurrent();

    ClientEntity findById(Long id);

    ClientEntity createbyadmin(ClientEntity clientDTO);

    List<ClientEntity> getAll();
}
