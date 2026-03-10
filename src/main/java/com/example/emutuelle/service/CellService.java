package com.example.emutuelle.service;

import com.example.emutuelle.entity.Cell;
import com.example.emutuelle.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellService {
    @Autowired
    private CellRepository cellRepository;

    public Cell createCell(Cell cell) {
        return cellRepository.save(cell);
    }

    public List<Cell> getAllCells() {
        return cellRepository.findAll();
    }
}