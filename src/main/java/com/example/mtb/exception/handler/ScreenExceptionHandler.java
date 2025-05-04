package com.example.mtb.exception.handler;

import com.example.mtb.exception.ScreenNotFoundException;
import com.example.mtb.utility.ErrorStructure;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ScreenExceptionHandler {

    private RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(ScreenNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handleScreenNotFoundException(ScreenNotFoundException ex){
        return restErrorBuilder.failure(ex, HttpStatus.NOT_FOUND, "Screen Not found");
    }
}
