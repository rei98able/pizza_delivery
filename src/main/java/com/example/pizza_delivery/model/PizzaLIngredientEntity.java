package com.example.pizza_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizza_l_ingredient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PizzaLIngredientEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
}