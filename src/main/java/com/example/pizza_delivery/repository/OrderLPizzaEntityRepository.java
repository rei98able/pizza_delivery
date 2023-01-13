package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.model.OrderLPizzaEntity;
import com.example.pizza_delivery.service.OrderLPizzaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLPizzaEntityRepository extends JpaRepository<OrderLPizzaEntity, Integer> {
    OrderLPizzaEntity findByPizza(Integer id);

    OrderLPizzaEntity findByOrder(Integer id);
}