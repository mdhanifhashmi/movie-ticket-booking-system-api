package com.example.mtb.exception.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<CustomFieldError> errors = new ArrayList<>();

        for (ObjectError objectError : ex.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            errors.add(CustomFieldError.builder()
                    .field(fieldError.getField())
                    .rejectedValue(fieldError.getRejectedValue())
                    .errorMessage(fieldError.getDefaultMessage())
                    .build());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseStructure.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message("invalid input")
                        .errors(errors)
                        .build());
    }

    @Builder
    @Getter
    public static class CustomFieldError {
        String field;
        Object rejectedValue;
        String errorMessage;

    }

    @Builder
    @Getter
    public static class ErrorResponseStructure {
        int status;
        String message;
        List<CustomFieldError> errors;
    }
}
