package com.example.pizza_delivery.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("CommonSubProcessCreate")
public class CommonSubProcessCreate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        delegateExecution.setVariable("approveAction", delegateExecution.getVariable("approveAction"));
    }
}