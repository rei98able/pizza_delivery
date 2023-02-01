package com.example.pizza_delivery.auth.security.service;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.ClientService;
import com.example.pizza_delivery.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientServiceImpl clientService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(
            String userLogin
    ) throws UsernameNotFoundException {
        try {
            ClientEntity client = clientService.findByLogin(userLogin);
            return CustomUserDetails.build(client);
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("User not found with login: " + userLogin);
        }
    }
}
