package com.example.pizza_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Long id;
    @Column(name = "status")
    private String status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private CityEntity city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private ClientEntity client;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "zakaz_pizza",
            joinColumns = @JoinColumn(name = "zakaz_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<PizzaEntity> pizza = new ArrayList<>();

}