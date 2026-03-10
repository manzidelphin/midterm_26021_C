package com.example.emutuelle.controller;

import com.example.emutuelle.entity.Province;
import com.example.emutuelle.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        Province createdProvince = provinceService.createProvince(province);
        return new ResponseEntity<>(createdProvince, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvinces() {
        List<Province> provinces = provinceService.getAllProvinces();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable Long id) {
        Province province = provinceService.getProvinceById(id);
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable Long id, @RequestBody Province province) {
        Province updatedProvince = provinceService.updateProvince(id, province);
        return new ResponseEntity<>(updatedProvince, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}