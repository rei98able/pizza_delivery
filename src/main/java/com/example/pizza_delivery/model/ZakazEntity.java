package com.example.pizza_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "zakaz")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZakazEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "zakaz_pizza",
            joinColumns = @JoinColumn(name = "zakaz_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID")
    )
    private List<PizzaEntity> pizza;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;



}