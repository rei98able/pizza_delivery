package com.example.pizza_delivery.auth.security.jwt;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * Created by ogbozoyan at 14.01.2023
 * github.com/ogbozoyan
 */
@Component
@Data
public class JwtRequest {
    private String username;
    private String password;
}

