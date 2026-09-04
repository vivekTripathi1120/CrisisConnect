package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.UserEmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserEmergencyContactRepository extends JpaRepository<UserEmergencyContact, Long> {
    Optional<UserEmergencyContact> findByUserAndDeletedFlagFalse(Long userId);

    Optional<UserEmergencyContact> findByUserIdAndEmergencyContactIdAndDeletedFlagFalse(Long userId, Long emergencyContId);

    List<UserEmergencyContact> findAllByUserIdAndDeletedFlagFalse(Long userId);
}