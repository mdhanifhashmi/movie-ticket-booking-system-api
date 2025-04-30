package com.example.mtb.service;

import com.example.mtb.dto.show.ShowRequest;
import com.example.mtb.dto.show.ShowResponse;
import jakarta.validation.Valid;

public interface ShowService {
    ShowResponse saveTheater(String theaterId, String screenId, @Valid ShowRequest showRequest);
}
