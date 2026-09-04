package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long administratorId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private Users user;

    @Column(name = "administrator_type", length = 50, nullable = false)
    private String administratorType;

    @Column(name = "designation", length = 150)
    private String designation;

    @Column(name = "organization_name", length = 255)
    private String organizationName;

    @Column(name = "verification_status", length = 50, nullable = false)
    private String verificationStatus;

    @Column(name = "verified_by")
    private Long verifiedBy;

    @Column(name = "deleted_flag")
    private Boolean deletedFlag;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
