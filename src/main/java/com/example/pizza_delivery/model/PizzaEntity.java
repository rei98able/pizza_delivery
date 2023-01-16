package com.example.pizza_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizza")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ZakazEntity> zakaz = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "pizza_ingredient",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientEntity> ingredient = new ArrayList<>();
}