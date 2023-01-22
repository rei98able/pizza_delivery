package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, Integer> {
    List<ClientEntity> findAll();
    ClientEntity findById(Long id);
    void deleteById(Long id);
    ClientEntity findByEmail(String email);

    ClientEntity findByLogin(String userLogin);

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);

    void deleteByLogin(String login);
}