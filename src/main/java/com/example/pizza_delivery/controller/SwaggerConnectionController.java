
package com.example.pizza_delivery.controller;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class SwaggerConnectionController {
    @GetMapping(value = "/")
    public void root(HttpServletResponse rsp) throws IOException {
        rsp.sendRedirect("swagger-ui/");
    }
}
