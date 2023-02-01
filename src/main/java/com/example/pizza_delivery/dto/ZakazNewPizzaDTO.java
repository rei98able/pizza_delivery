package com.example.pizza_delivery.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class ZakazNewPizzaDTO {
    private PizzaDTO pizza;
    private ZakazDTO zakaz;
}
