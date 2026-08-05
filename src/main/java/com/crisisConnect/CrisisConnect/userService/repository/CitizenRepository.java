package com.crisisConnect.CrisisConnect.userService.repository;

import com.crisisConnect.CrisisConnect.userService.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Citizen findByCitizenId(Long citId);
}