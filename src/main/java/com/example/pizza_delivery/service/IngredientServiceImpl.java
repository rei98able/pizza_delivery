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
public class IngredientServiceImpl implements IngredientService{
    private final IngredientEntityRepository ingredientEntityRepository;
    private final PizzaEntityRepository pizzaEntityRepository;
    @Override
    @Transactional(readOnly = true)
    public IngredientEntity save(IngredientEntity ingredientEntity) {
        return ingredientEntityRepository.save(ingredientEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Integer id) {
        try {
            ingredientEntityRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    @Transactional(readOnly = true)
    public IngredientService getIngredientById(Integer id) {
        return (IngredientService) ingredientEntityRepository.findById(id).orElse(null);
    }
}
