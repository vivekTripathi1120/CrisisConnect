package com.crisisConnect.CrisisConnect.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private Long errorCode;
    private String errorMsg;
    private Long timeStamp;
}
