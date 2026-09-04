package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user_emergency_profile")
public class UserEmergencyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emergencyProfileId;

    @OneToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "citizenId", nullable = false)
    private Citizen citizen;

    @Column(name = "blood_group", length = 10)
    private String bloodGroup;

    @Column(name = "medical_conditions", columnDefinition = "TEXT")
    private String medicalConditions;

    @Column(name = "allergies", columnDefinition = "TEXT")
    private String allergies;

    @Column(name = "special_requirements", columnDefinition = "TEXT")
    private String specialRequirements;

    @Column(name = "deleted_flag")
    private Boolean deletedFlag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
