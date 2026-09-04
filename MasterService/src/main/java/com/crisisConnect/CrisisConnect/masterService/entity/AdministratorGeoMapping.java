package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "adminstrator_geo_mapping")
public class AdministratorGeoMapping {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long mappingId;

        @ManyToOne
        @JoinColumn(name = "administrator_id", referencedColumnName = "administratorId", nullable = false)
        private Administrator administrator;

        @ManyToOne
        @JoinColumn(name = "geo_id", referencedColumnName = "geoId", nullable = false)
        private GeoStructure geoStructure;

        @Column(name = "is_primary", nullable = false)
        private Boolean isPrimary = false;

        @Column(name = "is_active", nullable = false)
        private Boolean isActive = true;

        @Column(name = "deleted_flag")
        private Boolean deletedFlag;

        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
}
