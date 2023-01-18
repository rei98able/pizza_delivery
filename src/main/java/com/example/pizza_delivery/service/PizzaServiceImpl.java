package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.PizzaEntity;
import com.example.pizza_delivery.repository.IngredientEntityRepository;
import com.example.pizza_delivery.repository.PizzaEntityRepository;
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
    private final IngredientEntityRepository ingredientEntityRepository;

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

}
