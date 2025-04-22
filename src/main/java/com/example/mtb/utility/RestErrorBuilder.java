package com.example.mtb.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestErrorBuilder {
    public <t> ResponseEntity<ErrorStructure<String>> failure (RuntimeException ex, HttpStatus status, String data){
        ErrorStructure<String> errorStructure = ErrorStructure
                .<String>builder()
                .error(status.value())
                .message(ex.getMessage())
                .date(data)
                .build();

        return ResponseEntity.status(status).body(errorStructure);
    }
}
