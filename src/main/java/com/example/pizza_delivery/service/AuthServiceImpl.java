package com.example.pizza_delivery.service;

import com.example.pizza_delivery.auth.security.jwt.JwtProvider;
import com.example.pizza_delivery.auth.security.jwt.JwtResponse;
import com.example.pizza_delivery.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    @Override
    public ResponseEntity<JwtResponse> signIn(LoginDTO loginDTO) {
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
}
