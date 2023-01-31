package com.example.pizza_delivery.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Java delegate that sets statuses dynamically
 *
 * @inheritDoc FnpDelegate - abstract delegate with base functions to work with process
 * @implNote JavaDelegate - Camunda delegate that is used on start or end of current execution
 */
@Component("StatusHandler")
public class StatusHandler extends FnpDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        delegateExecution.setVariable("status", delegateExecution.getCurrentActivityName());
    }
}
