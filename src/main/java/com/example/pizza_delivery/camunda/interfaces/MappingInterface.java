package com.example.pizza_delivery.camunda.interfaces;

@FunctionalInterface
public interface MappingInterface {
    void map(VariableInterface taskVars, VariableInterface processVars);
}
