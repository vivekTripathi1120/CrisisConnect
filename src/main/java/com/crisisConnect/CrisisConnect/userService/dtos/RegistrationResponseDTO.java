package com.crisisConnect.CrisisConnect.userService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponseDTO {

    private Long usrId;
    private String name;
    private Long phoneNum;
}
