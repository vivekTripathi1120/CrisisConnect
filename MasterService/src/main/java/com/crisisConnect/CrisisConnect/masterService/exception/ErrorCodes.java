package com.crisisConnect.CrisisConnect.masterService.exception;

public enum ErrorCodes {

    ERRORCODES_2001(2001L, "User already exists"),
    ERRORCODES_2002(2002L, "Invalid OTP"),
    ERRORCODES_2003(2003L, "User not found"),
    ERRORCODES_2004(2004L, "Mobile number already registered"),
    ERRORCODES_2005(2005L, "Email already registered"),
    ERRORCODES_2006(2006L, "Geo Local Not FOUND")
    ;

    private final Long errorCode;
    private final String errorMsg;

    ErrorCodes(Long errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}