package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.auth.security.jwt.JwtProvider;
import com.example.pizza_delivery.dto.IngredientDTO;
import com.example.pizza_delivery.model.IngredientEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.IngredientServiceImpl;
import com.example.pizza_delivery.service.PizzaServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class IngredientController {
    private final PizzaServiceImpl pizzaServiceImpl;
    private final ZakazServiceImpl zakazServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final IngredientServiceImpl ingredientServiceImpl;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping("/availableingredient")
    public List<IngredientEntity> getAvailableIngredient() {
        log.info("get available ingredient");
        return ingredientServiceImpl.getAll();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public void addIngredient(@RequestBody IngredientEntity ingredientDTO) {
        log.info("add ingredient");
        ingredientServiceImpl.save(ingredientDTO);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete/{id}")
    public void deleteIngredient(@PathVariable Integer id) {
        log.info("delete ingredient");
        ingredientServiceImpl.delete(id);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update")
    public void updateIngredient(@RequestBody IngredientDTO ingredientDTO) {
        log.info("update ingredient");
        ingredientServiceImpl.update(ingredientDTO);
    }
}
