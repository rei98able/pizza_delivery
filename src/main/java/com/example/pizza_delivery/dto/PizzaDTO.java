package com.example.pizza_delivery.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PizzaDTO {
    @NotBlank
    private String name;
    @NotBlank
    private Integer price;
}
