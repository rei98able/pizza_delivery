package com.example.pizza_delivery.service;

import com.example.pizza_delivery.dto.IngredientDTO;
import com.example.pizza_delivery.model.IngredientEntity;
import io.swagger.models.auth.In;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface IngredientService {
    IngredientEntity save(IngredientEntity ingredientEntity);

    void delete(Integer id);

    IngredientEntity getIngredientById(Integer id);

    IngredientEntity update(IngredientDTO ingredientDTO);
}
