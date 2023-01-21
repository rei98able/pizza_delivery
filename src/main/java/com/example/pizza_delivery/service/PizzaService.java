package com.example.pizza_delivery.service;

import com.example.pizza_delivery.dto.PizzaDTO;
import com.example.pizza_delivery.model.PizzaEntity;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */

public interface PizzaService {

    PizzaEntity save(PizzaEntity pizzaEntity);

    void delete(Integer id);

    PizzaEntity newPizza(PizzaDTO pizzaDTO);
    PizzaEntity updatePizza(PizzaDTO pizzaDTO);
    PizzaEntity getByName(String name);
}
