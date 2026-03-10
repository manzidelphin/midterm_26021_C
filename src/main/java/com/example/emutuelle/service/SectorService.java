package com.example.emutuelle.service;

import com.example.emutuelle.entity.Sector;
import com.example.emutuelle.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    public Sector createSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }
}