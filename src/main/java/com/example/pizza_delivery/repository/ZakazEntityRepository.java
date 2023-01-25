package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.ZakazEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZakazEntityRepository extends JpaRepository<ZakazEntity, Integer> {
}