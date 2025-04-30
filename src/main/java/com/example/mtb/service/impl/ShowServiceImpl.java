package com.example.mtb.service.impl;

import com.example.mtb.dto.show.ShowRequest;
import com.example.mtb.dto.show.ShowResponse;
import com.example.mtb.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {
    @Override
    public ShowResponse saveTheater(String theaterId, String screenId, ShowRequest showRequest) {
        return null;
    }
}
