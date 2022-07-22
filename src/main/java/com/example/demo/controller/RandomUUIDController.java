package com.example.demo.controller;

import com.example.demo.entity.Random;
import com.example.demo.service.RandomUUIDService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@AllArgsConstructor
public class RandomUUIDController {

    private final RandomUUIDService randomUUIDService;

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping("random")
    public ResponseEntity<Random> generateNewUUID() {

        return ResponseEntity.ok(randomUUIDService.generateNewUUID());
    }

}
