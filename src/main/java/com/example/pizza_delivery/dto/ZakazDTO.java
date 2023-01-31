package com.example.pizza_delivery.dto;

import com.example.pizza_delivery.model.PizzaEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ZakazDTO {
    @NotBlank
    private String address;
    @NotBlank
    private String name;
    @NotBlank
    private String login;
    private String status;
    @NotBlank
    private List<String> pizzaName;

}
