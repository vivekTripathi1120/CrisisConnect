package com.crisisConnect.CrisisConnect.masterService.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "rescue_camps")
public class RescueCamps {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long resCamId;

    private String resCamName;
    private String resCamAddress;
    private Long noOfAvalAccom;
    private Long noOfOccupied;
    private Long noOfDaysAvalFood;
    private Boolean medicalAssAval;
    private Boolean verified;
}
