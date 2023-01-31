package com.example.pizza_delivery.camunda.interfaces;

public interface VariableInterface {
    Object get(String name);

    void set(String name, Object value);
}
