package com.example.emutuelle.controller;

import com.example.emutuelle.entity.District;
import com.example.emutuelle.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        District createdDistrict = districtService.createDistrict(district);
        return new ResponseEntity<>(createdDistrict, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }
}