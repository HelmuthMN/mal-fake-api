package com.demo.malfakeapi.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataError {

    private String details;

    private String message;

    private Integer httpCode;

    public DataError(String details, Integer httpCode, String message) {
        this.details = details;
        this.httpCode = httpCode;
        this.message = message;
    }
}
