package com.crisisConnect.CrisisConnect.masterService.dtos;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserAddressReqDTO {

    private String addressLine;
    private String landMark;
    private String postalCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Boolean isPrimary;
    private Long geoStructId;

}
