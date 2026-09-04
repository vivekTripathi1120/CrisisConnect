package com.crisisConnect.CrisisConnect.exception;

public enum ErrorCodes {

    CITIZEN_WRONG_UNIQUE_ID(5001L, "User already exists"),

    INVALID_OTP(5002L, "Invalid OTP"),

    USER_NOT_FOUND(5003L, "User not found"),

    MOBILE_ALREADY_REGISTERED(5004L, "Mobile number already registered"),

    EMAIL_ALREADY_REGISTERED(5005L, "Email already registered");

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