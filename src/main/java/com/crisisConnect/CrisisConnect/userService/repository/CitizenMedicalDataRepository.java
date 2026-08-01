package com.crisisConnect.CrisisConnect.userService.repository;

import com.crisisConnect.CrisisConnect.userService.entity.CitizenMedicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenMedicalDataRepository extends JpaRepository<CitizenMedicalData, Long> {
}