package com.example.mtb.dto.theater;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TheaterRequest(
        @NotBlank(message = "You can't leave the name blank")
        String name,
        @NotBlank
        String address,
        @NotNull
        String city,
        @NotNull
        String landmark

) {
}
