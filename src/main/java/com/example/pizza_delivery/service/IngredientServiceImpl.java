package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.IngredientEntity;
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
public class IngredientServiceImpl implements IngredientService {
    private final IngredientEntityRepository ingredientEntityRepository;
    private final PizzaEntityRepository pizzaEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public IngredientEntity save(IngredientEntity ingredientEntity) {
        return ingredientEntityRepository.save(ingredientEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ingredientEntityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientEntity getIngredientById(Integer id) {
        return ingredientEntityRepository.findById(id).orElse(null);
    }
}
