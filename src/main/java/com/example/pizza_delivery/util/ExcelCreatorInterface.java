package com.example.pizza_delivery.util;

import com.example.pizza_delivery.model.ClientEntity;

import java.util.List;

public interface ExcelCreatorInterface {
    String createExcel(String fileName, List<ClientEntity> object);
}
