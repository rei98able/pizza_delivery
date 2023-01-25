package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.dto.PizzaDTO;
import com.example.pizza_delivery.model.PizzaEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.IngredientServiceImpl;
import com.example.pizza_delivery.service.PizzaServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pizza")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class PizzaController {
    private final PizzaServiceImpl pizzaServiceImpl;
    private final ZakazServiceImpl zakazServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final IngredientServiceImpl ingredientServiceImpl;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping("/all")
    public List<PizzaEntity> getAll() {
        log.info("get all pizzas");
        return pizzaServiceImpl.getALL();
    }

    @SneakyThrows
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/new")
    public PizzaEntity newPizza(@RequestBody PizzaDTO pizzaDTO) {
        log.info("new pizza");
        return pizzaServiceImpl.newPizza(pizzaDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deletePizza(@PathVariable Integer id) {
        log.info("delete pizza");
        pizzaServiceImpl.delete(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public PizzaEntity updatePizza(@PathVariable Integer id, @RequestBody PizzaDTO pizzaDTO) {
        log.info("update pizza");

        return pizzaServiceImpl.updatePizza(id,pizzaDTO);
    }

}
