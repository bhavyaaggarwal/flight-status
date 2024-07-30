package com.example.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<BaseError> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(new BaseError(
                ex.getErrorReasonCode()
                        .getCode(),
                CustomException.BASE_ERROR_MESSAGE.concat(ex.getErrorReasonCode()
                                .getDescription())
                        .concat(". ")
                        .concat(ex.getMessage())
        ), ex.getStatus());
    }
}
