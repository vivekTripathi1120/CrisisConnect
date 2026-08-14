package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;

    private String citizenName;
    private Long aadharCardNumber;
    private Long phoneNumber;
    private Boolean phoneVerified;
    private Long emergencyContactNumber;
    private Boolean emergencyConNumVerified;
    private String permanentAddress;
    private String currentAddress;
    private Integer familyMember;
    private Long zipCode;
    private Long cityId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

}
