package com.crisisConnect.CrisisConnect.masterService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitizenReqDTO {

    private Long citizenId;
    private Long dateOfBirth;
    private String gender;
    private Integer familyMemberCount;
}
