package com.crisisConnect.CrisisConnect.masterService.entity;

import com.crisisConnect.CrisisConnect.masterService.utils.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.EnumNaming;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = {"email","phoneNumber"})} )
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 20, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email_verified", nullable = false)
    private Boolean emailVerified = false;

    @Column(name = "phone_verified", nullable = false)
    private Boolean phoneVerified = false;

    @Column(name = "deleted_flag")
    private Boolean deletedFlag = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 100, nullable = false)
    private String createdBy;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

}
