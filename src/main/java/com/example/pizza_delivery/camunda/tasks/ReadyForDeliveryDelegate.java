package com.example.pizza_delivery.camunda.tasks;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.model.ZakazEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("readyForDeliveryDelegate")
@Slf4j
@RequiredArgsConstructor
public class ReadyForDeliveryDelegate implements JavaDelegate {
    private final ClientServiceImpl clientService;
    private final ZakazServiceImpl zakazService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("ReadyForDeliveryDelegate");

        ZakazEntity zakazEntity = zakazService.getZakazById((Integer) execution.getVariable("zakazId"));
        zakazEntity.setStatus("Ready");
        zakazService.save(zakazEntity);
        execution.setVariable("status", zakazEntity.getStatus());
    }
}
