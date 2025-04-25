package com.example.mtb.service.impl;

import com.example.mtb.dto.theater.TheaterRequest;
import com.example.mtb.dto.theater.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetail;
import com.example.mtb.exception.TheaterNotFoundException;
import com.example.mtb.exception.UserNotFoundException;
import com.example.mtb.mapper.TheaterMapper;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Collections.copy;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final UserRepository userRepository;
    private final TheaterMapper theaterMapper;

    @Override
    public TheaterResponse saveTheater(String email, TheaterRequest theaterRequest) {
        UserDetail userDetail = userRepository.findByEmail(email);

        if (userDetail instanceof TheaterOwner theaterOwner) {
            Theater theater = theaterMapper.toEntity(theaterRequest);
            theater.setTheaterOwner(theaterOwner);

            theaterRepository.save(theater);
            return theaterMapper.toResponse(theater);

        } else
            throw new UserNotFoundException("Theater Owner doesn't exist");

    }

    @Override
    public TheaterResponse findTheater(String theaterId) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new TheaterNotFoundException("Theater does not exist in database"));
        return theaterMapper.toResponse(theater);
    }

    @Override
    public TheaterResponse updateTheater(String theaterId, TheaterRequest theaterRequest) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new TheaterNotFoundException("Theater does not exist in database"));

        theaterMapper.toEntity(theaterRequest, theater);
        theaterRepository.save(theater);

        return theaterMapper.toResponse(theater);
    }


}
