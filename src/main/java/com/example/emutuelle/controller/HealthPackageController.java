package com.example.emutuelle.controller;

import com.example.emutuelle.entity.HealthPackage;
import com.example.emutuelle.service.HealthPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class HealthPackageController {

    @Autowired
    private HealthPackageService healthPackageService;

    @PostMapping
    public ResponseEntity<HealthPackage> createPackage(@RequestBody HealthPackage healthPackage) {
        HealthPackage createdPackage = healthPackageService.createPackage(healthPackage);
        return new ResponseEntity<>(createdPackage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HealthPackage>> getAllPackages() {
        List<HealthPackage> packages = healthPackageService.getAllPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }
}