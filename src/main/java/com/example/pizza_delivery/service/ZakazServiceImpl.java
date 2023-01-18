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
}

