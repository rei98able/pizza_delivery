package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaEntityRepository extends JpaRepository<PizzaEntity, Integer> {
    PizzaEntity findByName(String name);
    @Modifying
    @Query("delete from PizzaEntity p where p.id = ?1")
    void deleteById(Integer id);
}