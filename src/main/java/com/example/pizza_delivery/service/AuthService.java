package com.example.pizza_delivery.service;

import com.example.pizza_delivery.auth.security.jwt.JwtResponse;
import com.example.pizza_delivery.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<JwtResponse> signIn(LoginDTO loginDTO);
}
