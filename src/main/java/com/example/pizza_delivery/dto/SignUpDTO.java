package com.example.pizza_delivery.dto;

import com.example.pizza_delivery.auth.security.service.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */
@Data
public class SignUpDTO {
    private String login;
    private String password;
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
