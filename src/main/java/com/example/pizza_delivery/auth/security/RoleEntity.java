package com.example.pizza_delivery.auth.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by ogbozoyan at 14.01.2023
 * github.com/ogbozoyan
 */
@Entity
@Table(name = "system_r_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "icon")
    private String icon;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
}


