package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.OrderLPizzaEntity;
import com.example.pizza_delivery.repository.OrderLPizzaEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class OrderLPizzaServiceImpl implements OrderLPizzaService{
    private final OrderLPizzaEntityRepository orderLPizzaEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public OrderLPizzaEntity save(OrderLPizzaEntity orderEntity) {
        return orderLPizzaEntityRepository.save(orderEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Integer id) {
        try {
            orderLPizzaEntityRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderLPizzaEntity> getOrderLPizzaById(Integer id) {
        return orderLPizzaEntityRepository.findById(id);
    }

    @Override
    public OrderLPizzaEntity getOrderLPizzaByOrder(Integer id) {
        return orderLPizzaEntityRepository.findByOrder(id);
    }

    @Override
    public OrderLPizzaEntity getOrderLPizzaByPizza(Integer id) {
        return orderLPizzaEntityRepository.findByPizza(id);
    }
}
