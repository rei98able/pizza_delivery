package com.example.pizza_delivery.controller;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */


import com.example.pizza_delivery.auth.security.jwt.JwtResponse;
import com.example.pizza_delivery.dto.LoginDTO;
import com.example.pizza_delivery.dto.SignUpDTO;
import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.AuthService;
import com.example.pizza_delivery.service.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final ClientServiceImpl clientService;
    private final AuthService authService;
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
        return authService.signIn(loginDTO);
    }

    @PostMapping("/signup")
    public ResponseEntity<ClientEntity> signUp(@Valid @RequestBody SignUpDTO signUpDTO) {
        log.info(signUpDTO.toString());
        if (clientService.exist(signUpDTO.getLogin(), signUpDTO.getEmail())) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok(clientService.signUp(signUpDTO));
    }
}
