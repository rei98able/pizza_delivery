package com.example.pizza_delivery.auth.security.service;

import com.example.pizza_delivery.model.ClientEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by ogbozoyan at 14.01.2023
 * github.com/ogbozoyan
 */
@Data
@Builder
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String login;
    @JsonIgnore
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(
            Long id,
            String login,
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomUserDetails user = (CustomUserDetails) o;
        return Objects.equals(id, user.id);
    }

    public static CustomUserDetails build(
            ClientEntity user
    ) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
        return new CustomUserDetails(
                user.getId(),
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

}
