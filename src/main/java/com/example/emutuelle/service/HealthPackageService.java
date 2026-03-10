package com.example.emutuelle.service;

import com.example.emutuelle.entity.HealthPackage;
import com.example.emutuelle.repository.HealthPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthPackageService {
    @Autowired
    private HealthPackageRepository healthPackageRepository;

    public HealthPackage createPackage(HealthPackage healthPackage) {
        return healthPackageRepository.save(healthPackage);
    }

    public List<HealthPackage> getAllPackages() {
        return healthPackageRepository.findAll();
    }
}