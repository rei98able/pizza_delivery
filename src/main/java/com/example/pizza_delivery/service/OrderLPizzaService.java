package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.OrderLPizzaEntity;

import java.util.Optional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface OrderLPizzaService {
    OrderLPizzaEntity save(OrderLPizzaEntity orderEntity);

    void delete(Integer id);

    Optional<OrderLPizzaEntity> getOrderLPizzaById(Integer id);

    OrderLPizzaEntity getOrderLPizzaByOrder(Integer id);

    OrderLPizzaEntity getOrderLPizzaByPizza(Integer id);
}

