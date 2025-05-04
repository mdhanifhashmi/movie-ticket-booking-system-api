package com.example.mtb.service.impl;

import com.example.mtb.dto.screen.ScreenRequest;
import com.example.mtb.dto.screen.ScreenResponse;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.entity.Theater;
import com.example.mtb.exception.ScreenNotFoundException;
import com.example.mtb.exception.TheaterNotFoundException;
import com.example.mtb.mapper.ScreenMapper;
import com.example.mtb.repository.ScreenRepository;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.service.ScreenService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;
    private final ScreenMapper screenMapper;



    @Override
    public ScreenResponse saveScreen(String theaterId, ScreenRequest screenRequest) {
        Theater theater = screenRepository.findById(theaterId)
                .orElseThrow(() -> new TheaterNotFoundException("Theater does not exist in database"))
                .getTheater();

        Screen screen = screenMapper.toEntity(screenRequest);
        screen.setTheater(theater);
        screen.setSeats(createSeat( screen ));

        screenRepository.save(screen);
        return  screenMapper.toResponse(screen);
    }

    @Override
    public ScreenResponse findScreen(String theaterId, String screenId) {
        if (theaterRepository.existsById(theaterId)){
                return screenMapper.toResponse(screenRepository.findById(screenId)
                        .orElseThrow(() -> new ScreenNotFoundException("Screen doesn't exist in database with id"+screenId)));
        }
        throw new TheaterNotFoundException("theater doesn't exist in database with id:"+theaterId);
    }

    private List<Seat> createSeat(Screen screen) {

        List<Seat> seats = new LinkedList<>();
        int noOfSeatPerRow = screen.getCapacity() / screen.getNoOfRows();

        for (int i=65; i<=65+screen.getNoOfRows(); i++){
            char row = (char) i;
            for(int j=1; j<=noOfSeatPerRow; j++){
                Seat seat = new Seat();
                seat.setScreen(screen);
                seat.setDelete(false);

                seat.setSeatName(String.valueOf(row+j));

                seats.add(seat);
            }
        }
        return  seats;
    }



}
