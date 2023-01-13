package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.service.ClientService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@RestController
@Api(value = "ClientController", description = "REST APIs related to Client Entity")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
}
