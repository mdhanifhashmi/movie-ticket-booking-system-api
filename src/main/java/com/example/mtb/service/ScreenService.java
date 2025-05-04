package com.example.mtb.service;

import com.example.mtb.dto.screen.ScreenRequest;
import com.example.mtb.dto.screen.ScreenResponse;

public interface ScreenService {
    ScreenResponse saveScreen(String theaterId, ScreenRequest screenRequest);

    ScreenResponse findScreen(String theaterId, String screenId);
}
