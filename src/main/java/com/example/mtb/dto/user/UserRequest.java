package com.example.mtb.dto.user;

import java.time.LocalDate;

public record UserRequest (
        String username,
        String phoneNumber,
        LocalDate dateOfBirth,
        String password
) {}
