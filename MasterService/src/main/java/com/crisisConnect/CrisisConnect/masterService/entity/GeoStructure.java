package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "geo_structure")
public class GeoStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long geoId;

    private Integer geoLevel;

    private String geoName;

    private Long parentGeoId;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
