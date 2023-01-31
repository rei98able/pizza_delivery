package com.example.pizza_delivery.camunda.tasks;

import com.example.pizza_delivery.dto.ZakazDTO;
import com.example.pizza_delivery.model.ZakazEntity;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("createOrderDelegate")
@Slf4j
@RequiredArgsConstructor
public class CreateOrderDelegate implements JavaDelegate {
    private final ZakazServiceImpl zakazServiceImpl;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreateOrderDelegate");
        
        try{
            ZakazDTO zakazDTO = new ZakazDTO();
            zakazDTO.setAddress(execution.getVariable("address").toString());
            zakazDTO.setStatus("Created order");
            zakazDTO.setName(execution.getVariable("name").toString());
            zakazDTO.setLogin(execution.getVariable("login").toString());
            zakazDTO.setPizzaName((List<String>) execution.getVariable("pizzaName"));
            System.out.println(zakazDTO);
            System.out.println("Creating order");
            ZakazEntity zakazaka = zakazServiceImpl.newOrder(zakazDTO);
            System.out.println("Order created");
            execution.setVariable("isCreated", true);
            execution.setVariable("zakazId", zakazaka.getId());
        } catch (Exception e) {
            execution.setVariable("isCreated", false);
            execution.setVariable("zakazId", -1);
            e.printStackTrace();
        }
    }
}
