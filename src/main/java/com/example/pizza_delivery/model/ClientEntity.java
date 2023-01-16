package com.example.pizza_delivery.model;

import com.example.pizza_delivery.auth.security.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "login", nullable = false,unique = true,length = 20)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "r_auth_type_code")
    private String authTypeCode;
    @Column(name = "r_last_used_role_id")
    private Long lastUsedRoleId;
    @Column(name = "r_delivery_type_id")
    private Long deliveryTypeId;
    @Column(name = "email", nullable = false, unique = true,length = 256)
    @Type(type = "org.hibernate.type.TextType")
    private String email;

    @Column(name = "name", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String name;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ZakazEntity> zakazEntity = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "system_l_role_access",
            joinColumns = @JoinColumn(name = "r_user_id"),
            inverseJoinColumns = @JoinColumn(name = "r_role_id"))
    Set<RoleEntity> roles;


}