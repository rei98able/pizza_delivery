package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.model.OrderEntity;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface OrderService {
    OrderEntity save(OrderEntity orderEntity);
    void delete(Integer id);
    OrderEntity getOrderById(Integer id);
    OrderEntity getOrderByClient(Integer id);
    OrderEntity getOrderByPizza(Integer id);
    OrderEntity getOrderByClientAndPizza(Integer clientId, Integer pizzaId);
    OrderEntity getOrderByCity(Integer id);
    OrderEntity getOrderByClientAndCity(Integer clientId, Integer cityId);
    OrderEntity getOrderByPizzaAndCity(Integer pizzaId, Integer cityId);
    OrderEntity getOrderByClientAndPizzaAndCity(Integer clientId, Integer pizzaId, Integer cityId);
}
