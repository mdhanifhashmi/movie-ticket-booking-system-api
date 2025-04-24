package com.example.mtb.dto.user;

import com.example.mtb.enums.UserRole;

import java.time.LocalDate;

public record UserResponse(
        String userId,
        String username,
        String email,
        String phoneNumber,
        LocalDate dateOfBirth,
        UserRole userRole
) {}
