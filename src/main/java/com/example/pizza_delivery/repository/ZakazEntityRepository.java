package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.ZakazEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakazEntityRepository extends JpaRepository<ZakazEntity, Integer> {
    ZakazEntity findByPizzaAndCity(Integer pizzaId, Integer cityId);

    ZakazEntity findByCity(Integer id);

    ZakazEntity findByClient(Integer id);

    ZakazEntity findByPizza(Integer id);

    ZakazEntity findByClientAndPizza(Integer clientId, Integer pizzaId);

    ZakazEntity findByClientAndCity(Integer clientId, Integer cityId);

    ZakazEntity findByClientAndPizzaAndCity(Integer clientId, Integer pizzaId, Integer cityId);
}