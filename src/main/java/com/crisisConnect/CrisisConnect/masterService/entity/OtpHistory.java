package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "otp_history")
public class OtpHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long otpId;

    private Long otp;
    private Long userId;
    private Integer userType;
    private Integer phoneType;
    private Long phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
