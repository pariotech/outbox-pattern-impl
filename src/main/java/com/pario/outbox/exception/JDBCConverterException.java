package com.pario.outbox.exception;

/**
 * Created by Temire.Emmanuel on 30/01/2023
 */
public class JDBCConverterException extends RuntimeException{
    public JDBCConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
