package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_geo_mapping")
public class AdminstratorGeoMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long mappingId;

    private Long administratorId;

    private Long geoStructureId;

    private Boolean isActive;

}
