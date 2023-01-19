package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.IngredientServiceImpl;
import com.example.pizza_delivery.service.PizzaServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pizza")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class PizzaController {
    private final PizzaServiceImpl pizzaServiceImpl;
    private final ZakazServiceImpl zakazServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final IngredientServiceImpl ingredientServiceImpl;
}
