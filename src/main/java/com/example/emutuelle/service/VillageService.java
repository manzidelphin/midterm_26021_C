package com.example.emutuelle.service;

import com.example.emutuelle.entity.Village;
import com.example.emutuelle.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;

    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }

    public Optional<Village> getVillageById(Long id) {
        return villageRepository.findById(id);
    }

    public Village createVillage(Village village) {
        return villageRepository.save(village);
    }

    public Optional<Village> updateVillage(Long id, Village village) {
        return villageRepository.findById(id).map(existingVillage -> {
            existingVillage.setName(village.getName());
            existingVillage.setCode(village.getCode());
            existingVillage.setCell(village.getCell());
            return villageRepository.save(existingVillage);
        });
    }

    public boolean deleteVillage(Long id) {
        if (villageRepository.existsById(id)) {
            villageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}