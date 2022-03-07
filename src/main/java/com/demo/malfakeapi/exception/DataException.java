package com.demo.malfakeapi.exception;

import com.demo.malfakeapi.error.DataError;
import lombok.Getter;

@Getter
public class DataException extends RuntimeException{

    private DataError dataError;

    public DataException(DataError dataError) {
        super();
        this.dataError = dataError;
    }
}
