package com.example.pizza_delivery.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class ClientDTO {
    @NotBlank
    private String token;
    @NotBlank
    private String login;

    private String newLogin;
}
