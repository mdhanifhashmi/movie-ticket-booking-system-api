package com.example.mtb.service;

import com.example.mtb.dto.show.ShowResponse;

public interface ShowService {
    ShowResponse saveTheater(String theaterId, String screenId, String movieId, Long startsAt);
}
