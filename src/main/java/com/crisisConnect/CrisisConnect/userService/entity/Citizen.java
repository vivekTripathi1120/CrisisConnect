package com.crisisConnect.CrisisConnect.userService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

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
