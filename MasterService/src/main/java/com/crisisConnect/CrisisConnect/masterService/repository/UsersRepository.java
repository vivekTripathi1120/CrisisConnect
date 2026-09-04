package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmailAndDeletedFlagFalse(String email, String phoneNumber);

    Optional<Users> findAllByUserIdAndDeletedFlagFalse(Long userId);
}