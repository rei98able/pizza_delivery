package com.example.pizza_delivery.camunda.tasks;

import com.example.pizza_delivery.service.ZakazServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("deleteOrderDelegate")
@RequiredArgsConstructor
@Slf4j
public class DeleteOrderDelegate implements JavaDelegate {
    private final ZakazServiceImpl zakazServiceImpl;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("DeleteOrderDelegate");
        try {
            zakazServiceImpl.delete((Integer) execution.getVariable("zakazId"));
            execution.setVariable("isDeleted", true);
        }catch (Exception e){
            e.printStackTrace();
            execution.setVariable("isDeleted", false);
        }
    }
}
