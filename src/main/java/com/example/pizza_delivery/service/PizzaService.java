package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.PizzaEntity;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */

public interface PizzaService {
    PizzaEntity save(PizzaEntity pizzaEntity);

    void delete(Integer id);

    PizzaEntity getPizzaById(Integer id);

    PizzaEntity getPizzaByName(String name);

    PizzaEntity getPizzaByPrice(Integer price);

    PizzaEntity getPizzaByIngredient(Integer id);

    PizzaEntity getPizzaByZakaz(Integer id);
}
