package com.example.mtb.utility;

import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {

    public <T> ResponseEntity<ResponseStructure<T>> Success(HttpStatus status, String message, T data){

        ResponseStructure<T> str = ResponseStructure
                .<T>builder()
                .status(status.value())
                .message(message)
                .date(data)
                .build();

        return   ResponseEntity.status(status)
                .body(str);
    }
}
