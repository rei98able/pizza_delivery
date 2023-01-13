package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityEntityRepository extends JpaRepository<CityEntity, Integer> {
}