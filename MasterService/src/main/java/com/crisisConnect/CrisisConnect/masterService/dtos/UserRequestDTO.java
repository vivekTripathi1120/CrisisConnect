package com.crisisConnect.CrisisConnect.masterService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDTO {

    private LocalDate dateOfBirth;
    private String gender;
    private Integer familyMemberCount;
    private UserAddressReqDTO primaryAddress;
    private UserAddressReqDTO secondaryAddress;
    private EmergencyContactReqDTO emergencyContact;
    private userMedicalHistoryDTO medicalHistory;
}
