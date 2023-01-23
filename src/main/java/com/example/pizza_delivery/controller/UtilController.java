package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.service.ClientServiceImpl;
import com.example.pizza_delivery.util.ExcelCreatorImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/api/util")
public class UtilController {
    private final ClientServiceImpl clientServiceImpl;
    private final ExcelCreatorImpl excelCreatorImpl;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/result")
    public ResponseEntity<String> test()
    {
        log.info("result");
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy(HH:mm:ss)");
        Date date = new Date();
        String fileName = "Отчет " + formatter.format(date) + ".xlsx";
        List<ClientEntity> clientEntities = clientServiceImpl.getAll();
        return ResponseEntity.ok(excelCreatorImpl.createExcel(fileName, clientEntities));
    }
}

