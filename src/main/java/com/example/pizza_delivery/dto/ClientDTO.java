package com.example.pizza_delivery.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class ClientDTO {
    @NotBlank
    private String login;

    private String newLogin;

    @NotBlank
    private String password;

    private String newPassword;
}
