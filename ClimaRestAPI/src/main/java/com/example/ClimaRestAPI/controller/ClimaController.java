package com.example.ClimaRestAPI.controller;

import com.example.ClimaRestAPI.service.ClimaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/belo-horizonte")
    public ResponseEntity<Map<String, Object>> getClimaBeloHorizonte() {
        try {
            Map<String, Object> clima = climaService.obterClimaBeloHorizonte();
            return ResponseEntity.ok(clima);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("erro", e.getMessage()));
        }
    }
}