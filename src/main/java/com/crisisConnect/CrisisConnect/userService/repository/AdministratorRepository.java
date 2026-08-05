package com.crisisConnect.CrisisConnect.userService.repository;

import com.crisisConnect.CrisisConnect.userService.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUserId(Long verifrId);
}