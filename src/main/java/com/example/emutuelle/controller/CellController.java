package com.example.emutuelle.controller;

import com.example.emutuelle.entity.Cell;
import com.example.emutuelle.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cells")
public class CellController {
    @Autowired
    private CellService cellService;

    @PostMapping
    public ResponseEntity<Cell> createCell(@RequestBody Cell cell) {
        return new ResponseEntity<>(cellService.createCell(cell), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cell>> getAllCells() {
        return new ResponseEntity<>(cellService.getAllCells(), HttpStatus.OK);
    }
}