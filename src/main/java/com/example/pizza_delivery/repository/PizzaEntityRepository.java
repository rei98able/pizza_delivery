package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaEntityRepository extends JpaRepository<PizzaEntity, Integer> {
    PizzaEntity findByName(String name);
}