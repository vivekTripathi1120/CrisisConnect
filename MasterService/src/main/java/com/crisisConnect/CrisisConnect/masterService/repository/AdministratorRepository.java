package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUserId(Long verifrId);
}