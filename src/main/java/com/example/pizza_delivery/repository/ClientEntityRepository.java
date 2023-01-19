package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByEmail(String email);

    ClientEntity findByLogin(String userLogin);

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);

    void deleteByLogin(String login);
}