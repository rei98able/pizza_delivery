package com.example.pizza_delivery.service;

import com.example.pizza_delivery.model.ZakazEntity;
import com.example.pizza_delivery.repository.ZakazEntityRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class ZakazServiceImpl implements ZakazService {
    private final ZakazEntityRepository zakazEntityRepository;
    @Override
    @Transactional(readOnly = true)
    public ZakazEntity save(ZakazEntity zakazEntity) {
        return zakazEntityRepository.save(zakazEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        zakazEntityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazById(Integer id) {
        return zakazEntityRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByClient(Integer id) {
        return zakazEntityRepository.findByClient(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByPizza(Integer id) {
        return zakazEntityRepository.findByPizza(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByClientAndPizza(Integer clientId, Integer pizzaId) {
        return zakazEntityRepository.findByClientAndPizza(clientId, pizzaId);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByCity(Integer id) {
        return zakazEntityRepository.findByCity(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByClientAndCity(Integer clientId, Integer cityId) {
        return zakazEntityRepository.findByClientAndCity(clientId, cityId);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByPizzaAndCity(Integer pizzaId, Integer cityId) {
        return zakazEntityRepository.findByPizzaAndCity(pizzaId, cityId);
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazByClientAndPizzaAndCity(Integer clientId, Integer pizzaId, Integer cityId) {
        return zakazEntityRepository.findByClientAndPizzaAndCity(clientId, pizzaId, cityId);
    }
}

