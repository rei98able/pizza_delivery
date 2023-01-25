package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.ZakazEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakazEntityRepository extends JpaRepository<ZakazEntity, Integer> {
    @Modifying
    @Query("delete from ZakazEntity z where z.id = ?1")
    void deleteById(Integer id);
}