package com.crisisConnect.CrisisConnect.exception;

public class ErrorCode {

    private Long errorCode;
    private String errorMsg;

    public ErrorCode(Long errorCode, String errorMsg) {
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
