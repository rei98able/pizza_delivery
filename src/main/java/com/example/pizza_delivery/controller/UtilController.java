package com.example.pizza_delivery.controller;

import com.example.pizza_delivery.util.ExcelCreatorImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/api/util")
public class UtilController {

    private final ExcelCreatorImpl excelCreatorImpl;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/result")
    public ResponseEntity<String> test()
    {
        log.info("result");
        return ResponseEntity.ok(excelCreatorImpl.createExcel());
    }

    @SneakyThrows
    @PostMapping("file/upload")
    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file){
        log.info("uploadFile");
        try {
            Files.write(Paths.get("src//main//resources//Files/ " + file.getOriginalFilename()),file.getBytes());
            return ResponseEntity.ok("done");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}


