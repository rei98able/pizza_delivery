package com.example.pizza_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pizza")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PizzaEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredientEntity;

    @OneToMany(mappedBy = "pizzaEntity")
    private Set<OrderEntity> orderEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pizzaEntity")
    private Set<OrderLPizzaEntity> orderLPizzaEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pizzaEntity")
    private Set<IngredientEntity> ingredientEntities = new LinkedHashSet<>();

}