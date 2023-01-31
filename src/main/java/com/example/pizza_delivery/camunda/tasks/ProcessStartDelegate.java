package com.example.pizza_delivery.camunda.tasks;


import com.example.pizza_delivery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Common delegate that starts when process is started
 *
 * @implNote JavaDelegate - common Camunda delegate
 */
@Component("processStartDelegate")
@RequiredArgsConstructor
public class ProcessStartDelegate implements JavaDelegate {

    public static final int FIRST_STEP = 1;


    private final ClientService clientService;

    @Override
    public void execute(DelegateExecution process) {
        String businessKey = getBusinessKey(process);
        process.setProcessBusinessKey(businessKey);
        process.setVariable("initiatorLogin", clientService.getCurrent().getLogin());
        process.setVariable("whoStarted", clientService.getCurrent().getLogin());
        process.setVariable("processBusinessKey", businessKey);
        process.setVariable("currentStep", FIRST_STEP);

    }

    private String getBusinessKey(DelegateExecution process) {
        return process.getProcessInstance().getVariable("processDescr").toString() + " - " + process.getId();
    }

}
