package com.crisisConnect.CrisisConnect.userService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnboardingDTO {

    private String name;
    private Long uniqId;
    private Long ConNum;
    private Long emerConNum;
    private String address;
    private Integer headCount;
    private String currentAddress;
    private Long zipCode;
    private Long cityId;
    private Long serviceType;
}
