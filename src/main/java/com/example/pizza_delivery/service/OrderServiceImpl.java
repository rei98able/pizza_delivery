package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.OrderEntity;
import com.example.pizza_delivery.repository.OrderEntityRepository;
import com.example.pizza_delivery.repository.OrderLPizzaEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderEntityRepository orderEntityRepository;
    private final OrderLPizzaEntityRepository orderLPizzaEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public OrderEntity save(OrderEntity orderEntity) {
        return orderEntityRepository.save(orderEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Integer id) {
        try {
            orderEntityRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderById(Integer id) {
        return orderEntityRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByClient(Integer id) {
        return orderEntityRepository.findByClient(id);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByPizza(Integer id) {
        return orderEntityRepository.findByPizza(id);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByClientAndPizza(Integer clientId, Integer pizzaId) {
        return orderEntityRepository.findByClientAndPizza(clientId, pizzaId);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByCity(Integer id) {
        return orderEntityRepository.findByCity(id);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByClientAndCity(Integer clientId, Integer cityId) {
        return orderEntityRepository.findByClientAndCity(clientId, cityId);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByPizzaAndCity(Integer pizzaId, Integer cityId) {
        return orderEntityRepository.findByPizzaAndCity(pizzaId, cityId);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntity getOrderByClientAndPizzaAndCity(Integer clientId, Integer pizzaId, Integer cityId) {
        return orderEntityRepository.findByClientAndPizzaAndCity(clientId, pizzaId, cityId);
    }
}

