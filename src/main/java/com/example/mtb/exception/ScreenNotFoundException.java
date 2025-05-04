package com.example.mtb.exception;

public class ScreenNotFoundException extends RuntimeException {
    public ScreenNotFoundException(String message) {
        super(message);
    }
}
