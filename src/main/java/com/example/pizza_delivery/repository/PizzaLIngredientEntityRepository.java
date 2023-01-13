package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.PizzaLIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaLIngredientEntityRepository extends JpaRepository<PizzaLIngredientEntity, Integer> {
}