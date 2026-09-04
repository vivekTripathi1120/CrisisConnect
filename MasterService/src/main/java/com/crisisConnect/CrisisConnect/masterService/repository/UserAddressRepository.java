package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    Optional<UserAddress> findByUserAndIsPrimaryAndDeletedFlagFalse(Long userId, boolean b);

    List<UserAddress> findAllByUserAndDeletedFlagFalse(Long userId);
}