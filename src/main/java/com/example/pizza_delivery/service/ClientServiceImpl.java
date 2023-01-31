package com.example.pizza_delivery.service;

import com.example.pizza_delivery.auth.security.service.CustomUserDetails;
import com.example.pizza_delivery.auth.security.service.RoleEntity;
import com.example.pizza_delivery.dto.ClientDTO;
import com.example.pizza_delivery.dto.SignUpDTO;
import com.example.pizza_delivery.model.ClientEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.pizza_delivery.repository.ClientEntityRepository;
import com.example.pizza_delivery.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientEntityRepository clientEntityRepository;
    private final RoleEntityRepository roleEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public ClientEntity findById(Long id) {
        return clientEntityRepository.findById(id);
    }

    @Override
    @Transactional
    public ClientEntity createbyadmin(ClientEntity clientDTO) {
        Set<RoleEntity> role = new HashSet<>();
        role.add(roleEntityRepository.findByName("ROLE_CLIENT"));
        clientDTO.setRoles(role);
        clientDTO.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
        return clientEntityRepository.save(clientDTO);
    }

    @Override
    @Transactional
    public List<ClientEntity> getAll() {
        return clientEntityRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public ClientEntity getClientByEmail(String email) {
        return clientEntityRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public ClientEntity save(ClientEntity clientEntity) {
        return clientEntityRepository.save(clientEntity);
    }

    @Transactional
    public ClientEntity signUp(SignUpDTO signUpDTO){
        Set<RoleEntity> role = new HashSet<>();
        role.add(roleEntityRepository.findByName("ROLE_CLIENT"));
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setRoles(role);
        clientEntity.setLogin(signUpDTO.getLogin());
        clientEntity.setEmail(signUpDTO.getEmail());
        clientEntity.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        System.out.println(clientEntity);
        return clientEntityRepository.save(clientEntity);
    }
    @Override
    @Transactional
    public void delete(Long id) {
        ClientEntity Cur  = getCurrent();
        if (Cur.getId().equals(id)) {
            return;
        }
        else {
            clientEntityRepository.deleteById(id);
        }
    }
    @Override
    @Transactional
    public void deleteByLogin(String login) {
        clientEntityRepository.deleteByLogin(login);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ClientEntity> getAllClients() {
        return clientEntityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientEntity findByLogin(String userLogin) {
        return clientEntityRepository.findByLogin(userLogin);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientEntity findByEmail(String email) {
        return clientEntityRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean exist(String login, String email) {
        return clientEntityRepository.existsByLogin(login) || clientEntityRepository.existsByEmail(email);
    }

    @SneakyThrows
    @Override
    @Transactional(readOnly = true)
    public ClientEntity getCurrent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (auth == null) {
            throw new Exception("UserService.getCurrentUser(): Ошибка получения аутентификационных данных");
        }
        Object principal = auth.getPrincipal();
        String userInfo;
        System.out.println(principal);
        if (principal instanceof CustomUserDetails) {
            userInfo = ((CustomUserDetails) principal).getUsername();
            return findByLogin(userInfo);
        } else {
            throw new Exception("UserService.getCurrentUser(): Ошибка получения данных о пользователе");
        }
    }
    @Override
    public ResponseEntity<ClientEntity> update(ClientDTO clientDTO) {
        ClientEntity old = getCurrent();
        Optional<RoleEntity> adminRole = old.getRoles().stream()
                .filter(roleEntity -> roleEntity.getName().equals("ROLE_ADMIN"))
                .findAny();
        if (old.getLogin().equals(clientDTO.getLogin())) {
            log.info("update client");
            old.setLogin(clientDTO.getNewLogin());
            return ResponseEntity.ok(save(old));
        } else if (adminRole.get().getName().equals("ROLE_ADMIN")) {
            log.info("admin updating client");
            ClientEntity clientNewCredits = findByLogin(clientDTO.getLogin());
            clientNewCredits.setLogin(clientDTO.getNewLogin());
            return ResponseEntity.ok(save(clientNewCredits));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public List<ClientEntity> findByRole(String role) {
        List<ClientEntity> empl = clientEntityRepository.findAll().stream()
                .filter(clientEntity -> clientEntity.getRoles().stream()
                        .anyMatch(roleEntity -> roleEntity.getName().equals(role)))
                .collect(Collectors.toList());
        return empl;
    }

}
