package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.dto.IngredientDTO;
import com.example.pizza_delivery.model.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientEntityRepository extends JpaRepository<IngredientEntity, Integer> {
    List<IngredientEntity> findAll();

    List<IngredientEntity> findAllByLabel(String label);

    IngredientEntity findByLabel(String label);
    IngredientEntity findByValue(String value);
    @Modifying
    @Query("delete from IngredientEntity i where i.id = ?1")
    void deleteById(Integer id);
}