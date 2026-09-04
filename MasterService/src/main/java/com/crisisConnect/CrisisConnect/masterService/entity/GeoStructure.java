package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "geo_structure")
public class GeoStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long geoStructId;

    @Column(name = "geo_name", nullable = false)
    private String geoName;

    @Column(name = "geo_level", nullable = false)
    private Integer geoLevel;

    @ManyToOne
    @JoinColumn(name = "parent_geo_id")
    private GeoStructure parentGeo;

    @Column(name = "geo_code", length = 100)
    private String geoCode;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "deleted_flag")
    private Boolean deletedFlag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

}