package com.crisisConnect.CrisisConnect.userService.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long adminId;

    private Integer level; // 1-> gov level country, 2 -> state, 3 -> city
    private Integer parentLevelId;
    private Boolean verified;
}
