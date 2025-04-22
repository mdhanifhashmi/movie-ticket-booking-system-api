package com.example.mtb.dto;

import com.example.mtb.enums.UserRole;

import java.time.LocalDate;

public record UserRegistrationRequest (
        String username,
        String email,
        String phoneNumber,
        String password,
        LocalDate dateOfBirth,
        UserRole userRole
)
{
}
