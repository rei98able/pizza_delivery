package com.example.pizza_delivery.controller;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */

import com.example.pizza_delivery.auth.security.jwt.JwtProvider;
import com.example.pizza_delivery.auth.security.jwt.JwtResponse;
import com.example.pizza_delivery.auth.security.service.CustomUserDetailsService;
import com.example.pizza_delivery.dto.LoginDTO;
import com.example.pizza_delivery.dto.SignUpDTO;
import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final CustomUserDetailsService customUserDetailsService;
    private final ClientServiceImpl clientService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            String trimmedLoginInLowerCase = loginDTO.getLogin().trim();
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    trimmedLoginInLowerCase,
                    loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info(authToken.getAuthorities().toString());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtProvider.generateJwtToken(authentication);
            log.info(jwtToken);
            String login = jwtProvider.getLoginFromToken(jwtToken);
            return ResponseEntity.ok(new JwtResponse(jwtToken,login));
        } catch (InternalAuthenticationServiceException e){
            log.info("InternalAuthenticationServiceException| user dont exist?");
            return ResponseEntity.status(400).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
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
