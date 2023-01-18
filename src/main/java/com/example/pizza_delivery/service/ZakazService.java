package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.ZakazEntity;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface ZakazService {
    ZakazEntity save(ZakazEntity zakazEntity);

    void delete(Integer id);

    ZakazEntity getZakazById(Integer id);

    ZakazEntity getZakazByClient(Integer id);

    ZakazEntity getZakazByPizza(Integer id);

    ZakazEntity getZakazByClientAndPizza(Integer clientId, Integer pizzaId);
}
