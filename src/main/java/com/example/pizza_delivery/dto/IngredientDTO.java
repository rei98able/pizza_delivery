package com.example.pizza_delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {


    private String label;
    private String value;
    private String newLabel;
    private String newValue;
}
