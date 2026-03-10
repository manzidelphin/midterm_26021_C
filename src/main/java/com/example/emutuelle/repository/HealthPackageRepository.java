package com.example.emutuelle.repository;

import com.example.emutuelle.entity.HealthPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthPackageRepository extends JpaRepository<HealthPackage, Long> {}