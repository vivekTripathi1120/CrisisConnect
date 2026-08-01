package com.crisisConnect.CrisisConnect.userService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fire_stations")
public class FireStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long fireStatId;

    private String fireStatAddress;
    private String fireStatHeadCounts;
    private Long noOfAvalVehicle;
    private Boolean verified;
}
