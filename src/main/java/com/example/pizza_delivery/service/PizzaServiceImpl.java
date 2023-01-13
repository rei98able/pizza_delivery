package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.PizzaEntity;
import com.example.pizza_delivery.repository.IngredientEntityRepository;
import com.example.pizza_delivery.repository.OrderLPizzaEntityRepository;
import com.example.pizza_delivery.repository.PizzaEntityRepository;
import com.example.pizza_delivery.repository.PizzaLIngredientEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    private final PizzaEntityRepository pizzaEntityRepository;
    private final OrderLPizzaEntityRepository orderLPizzaEntityRepository;
    private final IngredientEntityRepository ingredientEntityRepository;
    private final PizzaLIngredientEntityRepository pizzaLIngredientEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public PizzaEntity save(PizzaEntity pizzaEntity) {
        return pizzaEntityRepository.save(pizzaEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        pizzaEntityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PizzaEntity getPizzaById(Integer id) {
        return pizzaEntityRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public PizzaEntity getPizzaByName(String name) {
        return pizzaEntityRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public PizzaEntity getPizzaByPrice(Integer price) {
        return pizzaEntityRepository.findByPrice(price);
    }

    @Override
    @Transactional(readOnly = true)
    public PizzaEntity getPizzaByIngredient(Integer id) {
        return pizzaEntityRepository.findByIngredient(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PizzaEntity getPizzaByOrder(Integer id) {
        return pizzaEntityRepository.findByOrder(id);
    }
}
