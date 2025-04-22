package com.example.mtb.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorStructure<T> {
    private int error;
    private String message;
    private T date;
}
