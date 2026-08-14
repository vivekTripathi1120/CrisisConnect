package com.crisisConnect.CrisisConnect.masterService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitizenDTO {

    private Long citId;
    private String name;
    private Long phoneNumber;
    private Long emergencyContactNumber;
    private String currAddress;
    private String permanentAddress;
    private Long zipCode;
    private Long cityId;
}
