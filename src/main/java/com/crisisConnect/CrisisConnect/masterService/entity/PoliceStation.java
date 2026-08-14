package com.crisisConnect.CrisisConnect.masterService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "police_station")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long polStatId;

    private String polStatAddress;
    private String statHeadCounts;
    private Boolean verified;
}
