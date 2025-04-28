package com.example.mtb.dto.screen;

import com.example.mtb.enums.ScreenType;

import java.util.List;

public record ScreenResponse (
        String screenId,
        ScreenType screenType,
        int capacity,
        int noOfRow,
        List<com.example.mtb.entity.Seat> seats
) { }
