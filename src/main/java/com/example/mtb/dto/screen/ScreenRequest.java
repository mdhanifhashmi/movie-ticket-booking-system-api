package com.example.mtb.dto.screen;

import com.example.mtb.enums.ScreenType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ScreenRequest(

        @NotNull(message = "Select type as IMAX, TWOD, or THREED")
        ScreenType screenType,
        @NotBlank(message = "Enter the no of capacity for people")
        int capacity,
        @Pattern(regexp = "^(?:[1-9]|1[0-9]|2[0-6])$", message = "Value must be between 1 and 26")
        int noOfRow
) {}
