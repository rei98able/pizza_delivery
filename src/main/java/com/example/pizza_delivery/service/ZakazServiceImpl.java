package com.example.pizza_delivery.service;

import com.example.pizza_delivery.dto.ZakazDTO;
import com.example.pizza_delivery.email.details.EmailDetails;
import com.example.pizza_delivery.email.service.EmailServiceImpl;
import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.model.PizzaEntity;
import com.example.pizza_delivery.model.ZakazEntity;
import com.example.pizza_delivery.repository.ClientEntityRepository;
import com.example.pizza_delivery.repository.ZakazEntityRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class ZakazServiceImpl implements ZakazService {
    private final ZakazEntityRepository zakazEntityRepository;
    private final ClientEntityRepository clientEntityRepository;
    private final ClientService clientServiceImpl;
    private final PizzaServiceImpl pizzaServiceImpl;
    private final EmailServiceImpl emailService;


    @Override
    @Transactional(readOnly = true)
    public ZakazEntity save(ZakazEntity zakazEntity) {
        return zakazEntityRepository.save(zakazEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ClientEntity clientEntity = clientServiceImpl.getCurrent();
        if(
                clientEntity.getRoles().stream()
                        .anyMatch(roleEntity -> roleEntity.getName().contains("ROLE_ADMIN"))
                        ||
                        clientEntity.getZakazEntity().stream()
                        .map(ZakazEntity::getId).anyMatch(id::equals)
        ) {
            zakazEntityRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("You are not permitted to do this");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ZakazEntity getZakazById(Integer id) {
        return zakazEntityRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ZakazEntity> getAll() {
        return zakazEntityRepository.findAll();
    }

    @Override
    @Transactional
    public ZakazEntity newOrder(ZakazDTO zakazDTO) {
        ClientEntity clientEntity = clientServiceImpl.getCurrent();
        System.out.println(clientEntity);
        if(
                clientEntity.getRoles().stream()
                .anyMatch(roleEntity -> roleEntity.getName().contains("ROLE_ADMIN"))
             || clientEntity.equals(clientEntityRepository.findByLogin(zakazDTO.getLogin()))
        ) {
            List<PizzaEntity> pizzaEntities = new ArrayList<>();
            ZakazEntity zakazEntity = new ZakazEntity();

            zakazEntity.setAddress(zakazDTO.getAddress());
            zakazEntity.setName(zakazDTO.getName());

            for (String pizzaEntityName : zakazDTO.getPizzaName()) {
                pizzaEntities.add(pizzaServiceImpl.getByName(pizzaEntityName));
            }
            zakazEntity.setPizza(pizzaEntities);
            zakazEntity.setStatus(zakazDTO.getStatus());
            zakazEntityRepository.save(zakazEntity);
            clientEntity.addZakaz(zakazEntity);
            clientServiceImpl.save(clientEntity);

            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setSubject("New order");
            emailDetails.setText("New order from " + zakazDTO.getName() + " with address " + zakazDTO.getAddress());
            emailDetails.setRecipient(clientServiceImpl.findByLogin(zakazDTO.getLogin()).getEmail());
            emailDetails.setAttachment(null);
            emailService.sendEmail(emailDetails);
            return zakazEntity;
        }
        else {
            throw new RuntimeException("You are not permitted to do this");
        }
    }
}

