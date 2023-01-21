package com.example.pizza_delivery.auth.security.jwt;

import com.example.pizza_delivery.auth.security.service.CustomUserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.HOURS;

/**
 * Created by ogbozoyan at 14.01.2023
 * github.com/ogbozoyan
 */
@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String JWT_SIGN_SECRET;

    public String generateJwtToken(
            Authentication authentication
    ) {
        CustomUserDetails clientDetails = (CustomUserDetails) authentication.getPrincipal();

        int jwtExpiration = 2;
        return Jwts.builder()
                .setSubject((clientDetails.getUsername()))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(jwtExpiration, HOURS)))
                .signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET)
                .compact();
    }

    public boolean validateToken(
            String token
    ) {
        try {
            Jwts.parser().setSigningKey(JWT_SIGN_SECRET).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            System.out.println("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            System.out.println("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            System.out.println("Malformed jwt");
        } catch (Exception e) {
            System.out.println("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(
            String token
    ) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SIGN_SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private String toJsonString(
            Serializable object
    ) {
        ObjectWriter writer = new ObjectMapper().writer();
        try {
            return writer.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(String.format("Could not transform object '%s' to JSON: ", object), e);
        }
    }
}