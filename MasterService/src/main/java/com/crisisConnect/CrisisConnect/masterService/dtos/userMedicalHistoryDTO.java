package com.crisisConnect.CrisisConnect.masterService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userMedicalHistoryDTO {

    private String bloodGroup;
    private String medicalCondition;
    private String allergies;
    private String specialRequirement;
}
