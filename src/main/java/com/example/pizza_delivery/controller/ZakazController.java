package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.dto.ZakazDTO;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.IngredientServiceImpl;
import com.example.pizza_delivery.service.PizzaServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ZakazController {
    private final PizzaServiceImpl pizzaServiceImpl;
    private final ZakazServiceImpl zakazServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final IngredientServiceImpl ingredientServiceImpl;

    @PostMapping("/new")
    public void newOrder(@Valid ZakazDTO zakazDTO) {
        log.info("new order");
    }

}
