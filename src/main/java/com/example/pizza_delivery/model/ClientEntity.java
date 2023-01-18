package com.example.pizza_delivery.model;

import com.example.pizza_delivery.auth.security.service.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "login")
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login", nullable = false, unique = true, length = 20)
    private String login;
    @Column(name = "password", nullable = false)

    private String password;
    @Column(name = "email", nullable = false, unique = true, length = 256)
    @Type(type = "org.hibernate.type.TextType")
    private String email;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "client_zakaz",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "zakaz_id", referencedColumnName = "ID")
    )
    private List<ZakazEntity> zakazEntity;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "system_l_role_access",
            joinColumns = @JoinColumn(name = "r_user_id"),
            inverseJoinColumns = @JoinColumn(name = "r_role_id"))
    Set<RoleEntity> roles = new HashSet<>();

    public void addZakaz(ZakazEntity zakazEntity) {
        this.zakazEntity.add(zakazEntity);
    }
}