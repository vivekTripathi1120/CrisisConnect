package com.crisisConnect.CrisisConnect.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestControllerAdvice
public class CustomValidationHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<ErrorResponse> handleCustomValidationException(
            CustomValidationException ex) {

        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ex.getError().getErrorCode());
        response.setErrorMsg(ex.getError().getErrorMsg());
        response.setTimeStamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        return ResponseEntity.badRequest().body(response);
    }


}
