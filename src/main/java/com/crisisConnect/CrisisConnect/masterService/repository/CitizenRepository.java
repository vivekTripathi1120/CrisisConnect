package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CitizenRepository extends JpaRepository<Citizen, Long> {

      @Query("Select cz from Citizen cz where citizenId = :citId ")
      //  @Query(value = "Select * from citizen where citizen_id = :citId ",nativeQuery = true) //jpa query
    Citizen findByCitizenId(Long citId);
}