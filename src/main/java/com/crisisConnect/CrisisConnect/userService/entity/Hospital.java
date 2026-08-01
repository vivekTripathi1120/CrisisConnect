package com.crisisConnect.CrisisConnect.userService.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long hospId;
    private String hospName;
    private String hospAddress;
    private Long noOfAvalBeds;
    private Long noOfAvalDoc;
    private Boolean verified;
    private Long noOfAmbul;
}
