package com.example.mtb.exception;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class InvalidDataInsertionException extends RuntimeException {

    public InvalidDataInsertionException(String message) {
        super(message);
    }
}
