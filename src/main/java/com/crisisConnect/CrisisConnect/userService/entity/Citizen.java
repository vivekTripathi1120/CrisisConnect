package com.crisisConnect.CrisisConnect.userService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String permanentAddress;
    private Integer familyMember;

}
