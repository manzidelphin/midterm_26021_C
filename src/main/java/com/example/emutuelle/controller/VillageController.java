package com.example.emutuelle.controller;

import com.example.emutuelle.entity.Village;
import com.example.emutuelle.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villages")
public class VillageController {

    @Autowired
    private VillageService villageService;

    @GetMapping
    public List<Village> getAllVillages() {
        return villageService.getAllVillages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Village> getVillageById(@PathVariable Long id) {
        return villageService.getVillageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Village createVillage(@RequestBody Village village) {
        return villageService.createVillage(village);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Village> updateVillage(@PathVariable Long id, @RequestBody Village village) {
        return villageService.updateVillage(id, village)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVillage(@PathVariable Long id) {
        if (villageService.deleteVillage(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}