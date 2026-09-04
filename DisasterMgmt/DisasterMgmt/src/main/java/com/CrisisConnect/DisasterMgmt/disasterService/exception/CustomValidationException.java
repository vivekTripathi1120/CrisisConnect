package com.CrisisConnect.DisasterMgmt.disasterService.exception;

public class CustomValidationException extends RuntimeException {

    private final ErrorCodes error;

    public CustomValidationException(ErrorCodes error) {
        super(error.getErrorMsg());
        this.error = error;
    }

    public ErrorCodes getError() {
        return error;
    }
}
