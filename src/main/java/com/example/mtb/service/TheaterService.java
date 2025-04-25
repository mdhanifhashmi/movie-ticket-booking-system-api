package com.example.mtb.service;

import com.example.mtb.dto.theater.TheaterRequest;
import com.example.mtb.dto.theater.TheaterResponse;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponse saveTheater(String email, TheaterRequest theaterRequest);

    TheaterResponse findTheater(String theaterId);

    TheaterResponse updateTheater(String theaterId, @Valid TheaterRequest theaterRequest);
}
