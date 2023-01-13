package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.OrderEntity;
import com.example.pizza_delivery.service.OrderLPizzaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findByClient(Integer id);

    OrderEntity findByPizza(Integer id);

    OrderEntity findByClientAndPizza(Integer clientId, Integer pizzaId);

    OrderEntity findByCity(Integer id);

    OrderEntity findByClientAndCity(Integer clientId, Integer cityId);

    OrderEntity findByPizzaAndCity(Integer pizzaId, Integer cityId);

    OrderEntity findByClientAndPizzaAndCity(Integer clientId, Integer pizzaId, Integer cityId);

    OrderLPizzaService findByOrder(Integer id);
}