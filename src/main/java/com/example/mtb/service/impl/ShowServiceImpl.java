package com.example.mtb.service.impl;

import com.example.mtb.dto.show.ShowResponse;
import com.example.mtb.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {

    
    @Override
    public ShowResponse saveShow(String theaterId, String screenId, String movieId, Long startsAt) {

        return null;
    }
}
