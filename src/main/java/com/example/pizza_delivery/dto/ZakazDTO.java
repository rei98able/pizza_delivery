package com.example.pizza_delivery.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ZakazDTO {
    @NotBlank
    private String address;
    @NotBlank
    private String name;
    @NotBlank
    private String status;

}
