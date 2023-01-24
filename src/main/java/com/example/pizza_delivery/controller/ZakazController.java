package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.dto.ZakazDTO;
import com.example.pizza_delivery.dto.ZakazNewPizzaDTO;
import com.example.pizza_delivery.model.ZakazEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.IngredientServiceImpl;
import com.example.pizza_delivery.service.PizzaServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ZakazController {
    private final PizzaServiceImpl pizzaServiceImpl;
    private final ZakazServiceImpl zakazServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final IngredientServiceImpl ingredientServiceImpl;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(zakazServiceImpl.getAll());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping("/new")
    public ResponseEntity<ZakazEntity> newOrder(@Valid @RequestBody ZakazDTO zakazDTO) {
        log.info("new order");
        return ResponseEntity.ok(zakazServiceImpl.newOrder(zakazDTO));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        log.info("delete order");
        zakazServiceImpl.delete(id);
        return ResponseEntity.ok().build();
    }
    @SneakyThrows
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping("/newPizza")
    public ResponseEntity<ZakazEntity> newPizza(@Valid @RequestBody ZakazNewPizzaDTO zakazDTO)
    {
        log.info("new pizza");
        pizzaServiceImpl.newPizza(zakazDTO.getPizza());

        return ResponseEntity.ok(zakazServiceImpl.newOrder(zakazDTO.getZakaz()));
    }
}
