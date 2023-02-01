package com.example.pizza_delivery.service;

import com.example.pizza_delivery.dto.ZakazDTO;
import com.example.pizza_delivery.model.ZakazEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
public interface ZakazService {
    ZakazEntity save(ZakazEntity zakazEntity);

    void delete(Integer id);

    ZakazEntity getZakazById(Integer id);

    ZakazEntity newOrder(ZakazDTO zakazDTO);
    List<ZakazEntity> getAll();
}
