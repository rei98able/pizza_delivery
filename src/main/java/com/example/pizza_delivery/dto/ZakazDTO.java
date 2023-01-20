package com.example.pizza_delivery.dto;

import com.example.pizza_delivery.model.PizzaEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ZakazDTO {
    @NotBlank
    private String address;
    @NotBlank
    private String name;
    private String status;
    PizzaEntity pizzaEntity;

}
