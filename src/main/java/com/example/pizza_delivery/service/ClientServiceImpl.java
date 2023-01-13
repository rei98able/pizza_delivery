package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.repository.ClientEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientEntityRepository clientEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientEntity> getClientById(Integer id) {
        return clientEntityRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientEntity getClientByEmail(String email) {
        return clientEntityRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientEntity save(ClientEntity clientEntity) {
        return clientEntityRepository.save(clientEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Integer id) {
        try {
            clientEntityRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
