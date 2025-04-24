package com.example.mtb.exception.handler;

import com.example.mtb.exception.UserExistByEmailException;
import com.example.mtb.exception.UserNotFoundException;
import com.example.mtb.utility.ErrorStructure;
import com.example.mtb.utility.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {
    private RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(UserExistByEmailException.class)
    public ResponseEntity<ErrorStructure<String>> handleUserExistByEmailException(UserExistByEmailException ex){
        return restErrorBuilder.failure(ex, HttpStatus.BAD_REQUEST,"User already exist");
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundException(UserNotFoundException ex){
        return restErrorBuilder.failure(ex, HttpStatus.NOT_FOUND, "User not found");
    }
}
