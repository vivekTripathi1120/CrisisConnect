package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.OtpHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpHistoryRepository extends JpaRepository<OtpHistory, Long> {
    OtpHistory findByIdAndPhoneNumberAndPhoneTypeAndUserType(Long citId, Long phoneNumber, Integer phoneType, Integer userType);
}