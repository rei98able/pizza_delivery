package com.example.pizza_delivery.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */
@Data
public class SignUpDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String login;
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^[a-zA-Z0-9[!@#$%^&*]]+$")
    private String password;
    @Email
    @NotBlank
    private String email;
    @Override
    public String toString() {
        return "SignUpDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
