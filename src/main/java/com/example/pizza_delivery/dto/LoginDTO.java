package com.example.pizza_delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
