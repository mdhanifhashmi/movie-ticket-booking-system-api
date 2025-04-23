package com.example.mtb.dto;

import com.example.mtb.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

public record UserRegistrationRequest (
        @NotBlank(message = "Name can't be left empty ")
        String username,
        @NotNull
        @Email
        String email,
        @NotNull
        @Pattern(regexp = "^[1-9]{1}[0-9]{9}$")
        String phoneNumber,
        @NotNull
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must be minimum 8 characters, include at least one uppercase letter, one lowercase letter, one number and one special character")
        String password,
        @NotNull
        LocalDate dateOfBirth,
        @NotNull
        UserRole userRole
)
{
}
