package com.example.mtb.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Builder
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T date;
}
