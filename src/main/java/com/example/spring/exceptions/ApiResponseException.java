package com.example.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiResponseException extends RuntimeException {
    private String message;
    private boolean success;

    public ApiResponseException(String message, boolean success) {
        super(message);
        this.message = message;
        this.success = success;
    }
}
