package com.example.pizza_delivery.repository;

import com.example.pizza_delivery.auth.security.service.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ogbozoyan at 17.01.2023
 * github.com/ogbozoyan
 */
@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByName(String name);
}
