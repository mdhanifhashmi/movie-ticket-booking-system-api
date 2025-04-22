package com.example.mtb.exception;

public class UserExistByEmailException extends RuntimeException {
    public UserExistByEmailException(String message) {
        super(message);
    }
}
