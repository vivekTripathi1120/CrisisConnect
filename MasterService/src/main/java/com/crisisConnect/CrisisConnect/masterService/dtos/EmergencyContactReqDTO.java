package com.crisisConnect.CrisisConnect.masterService.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmergencyContactReqDTO {

    private Long emergencyContId;
    private String contactName;
    private String relationShip;
    private String phoneNumber;
    private String email;
    private Boolean isPrimary;
}
