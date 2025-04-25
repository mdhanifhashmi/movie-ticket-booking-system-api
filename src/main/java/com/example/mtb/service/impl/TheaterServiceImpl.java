package com.example.mtb.service.impl;

import com.example.mtb.dto.theater.TheaterRequest;
import com.example.mtb.dto.theater.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetail;
import com.example.mtb.exception.UserNotFoundException;
import com.example.mtb.mapper.TheaterMapper;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final UserRepository userRepository;
    private final TheaterMapper theaterMapper;

    @Override
    public TheaterResponse saveTheater(String email, TheaterRequest theaterRequest) {
        UserDetail userDetail = userRepository.findByEmail(email);
        //Downcast to theater_owner
        TheaterOwner theaterOwner = (TheaterOwner) userDetail;

        if (userDetail == null){
            throw new UserNotFoundException("Theater Owner doesn't exist");
        }

        Theater theater = theaterMapper.toEntity(theaterRequest, theaterOwner);

        theaterRepository.save(theater);

        return theaterMapper.toResponse(theater);

    }


}
