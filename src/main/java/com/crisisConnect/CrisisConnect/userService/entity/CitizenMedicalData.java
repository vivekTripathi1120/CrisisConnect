package com.crisisConnect.CrisisConnect.userService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "citizen_medical_data")
public class CitizenMedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long citizenMedicalHisId;

    private String bloodGroup;
    private String medicalCondition;
}
