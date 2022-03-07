package com.demo.malfakeapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataExceptionHandler {
    @ExceptionHandler(DataException.class)
    public ResponseEntity handleDataException(DataException e) {
        return ResponseEntity.status(e.getDataError().getHttpCode()).body(e.getDataError());
    }
}
