package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.UserEmergencyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEmergencyProfileRepository extends JpaRepository<UserEmergencyProfile, Long> {
    Optional<UserEmergencyProfile> findByCitizenAndDeletedFlagFalse(Long citizenId);
}