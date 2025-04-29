package com.example.mtb.exception.handler;

import com.example.mtb.exception.InvalidDataInsertionException;
import com.example.mtb.utility.ErrorStructure;
import com.example.mtb.utility.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class DataInsertionExceptionHandler {

    private RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(InvalidDataInsertionException.class)
    private ResponseEntity<ErrorStructure<String>> handleInvalidDataInsertionException(InvalidDataInsertionException ex){
        return restErrorBuilder.failure(ex, HttpStatus.BAD_REQUEST, "Invalid Data insertion for entity");
    }

}
