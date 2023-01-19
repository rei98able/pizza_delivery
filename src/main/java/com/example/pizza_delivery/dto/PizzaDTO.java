package com.example.pizza_delivery.dto;

import com.example.pizza_delivery.model.IngredientEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class PizzaDTO {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private Integer price;
    private List<IngredientDTO> ingredients;
}
