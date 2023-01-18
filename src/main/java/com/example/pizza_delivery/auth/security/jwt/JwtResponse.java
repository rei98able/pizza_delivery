package com.example.pizza_delivery.auth.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by ogbozoyan at 14.01.2023
 * github.com/ogbozoyan
 */
@Component
@Data
public class JwtResponse {
    private String tokenType = "Bearer";
    private String accessToken;

    public JwtResponse() {
    }
    public JwtResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
