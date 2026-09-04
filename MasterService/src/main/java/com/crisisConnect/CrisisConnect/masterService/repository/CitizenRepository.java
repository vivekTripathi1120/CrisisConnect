package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findByUserIdAndDeletedFlagFalse(Long userId);
}