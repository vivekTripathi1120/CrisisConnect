package com.crisisConnect.CrisisConnect.userService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponseDTO {

    private String msg;
    private Boolean status;
    private Long id;
    private Long timeStamp;
}
