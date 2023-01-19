package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientEntityRepository extends JpaRepository<IngredientEntity, Integer> {
    List<IngredientEntity> findAll();
}