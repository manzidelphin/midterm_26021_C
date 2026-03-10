package com.example.emutuelle.controller;

import com.example.emutuelle.entity.Sector;
import com.example.emutuelle.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @PostMapping
    public ResponseEntity<Sector> createSector(@RequestBody Sector sector) {
        Sector createdSector = sectorService.createSector(sector);
        return new ResponseEntity<>(createdSector, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sector>> getAllSectors() {
        List<Sector> sectors = sectorService.getAllSectors();
        return new ResponseEntity<>(sectors, HttpStatus.OK);
    }
}