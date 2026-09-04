package com.crisisConnect.CrisisConnect.masterService.repository;

import com.crisisConnect.CrisisConnect.masterService.entity.GeoStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeoStructureRepository extends JpaRepository<GeoStructure, Long> {

    Optional<GeoStructure> findByGeoIdAndLevelAndDeletedFlagFalse(Long geoStructId, Integer cityGeoLvl);
}