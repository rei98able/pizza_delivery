package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.auth.security.jwt.JwtProvider;
import com.example.pizza_delivery.dto.ClientDTO;
import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.IngredientServiceImpl;
import com.example.pizza_delivery.service.PizzaServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ClientController {
    private final PizzaServiceImpl pizzaServiceImpl;
    private final ZakazServiceImpl zakazServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final IngredientServiceImpl ingredientServiceImpl;
    private final JwtProvider jwtProvider;

    @GetMapping("/current")
    @ResponseBody
    public ResponseEntity<ClientEntity> getCurrentUser() {
        return ResponseEntity.ok(clientServiceImpl.getCurrent());
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteClient(@Valid @RequestBody ClientDTO clientDTO) {
        log.info("delete client");
        if (jwtProvider.validateToken(clientDTO.getToken())) {
            if (clientDTO.getLogin().equals(jwtProvider.getLoginFromToken(clientDTO.getToken()))) {
                clientServiceImpl.deleteByLogin(clientDTO.getLogin());
                return ResponseEntity.ok().build();
            }

        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/update")
    public ResponseEntity<ClientEntity> update(@Valid @RequestBody ClientDTO clientDTO) {
        log.info("update client");
        if (jwtProvider.validateToken(clientDTO.getToken())) {
            if (clientDTO.getLogin().equals(jwtProvider.getLoginFromToken(clientDTO.getToken()))) {
                return ResponseEntity.ok(clientServiceImpl.update(clientDTO.getNewLogin()));
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
