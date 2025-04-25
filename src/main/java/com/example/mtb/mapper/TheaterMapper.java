package com.example.mtb.mapper;

import com.example.mtb.dto.theater.TheaterRequest;
import com.example.mtb.dto.theater.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {
    public Theater toEntity(TheaterRequest theaterRequest, TheaterOwner theaterOwner) {
        Theater newTheater = new Theater();

        newTheater.setTheaterOwner(theaterOwner);

        newTheater.setName(theaterRequest.name());
        newTheater.setAddress(theaterRequest.address());
        newTheater.setCity(theaterRequest.city());
        newTheater.setLandmark(theaterRequest.landmark());

        return  newTheater;
    }

    public TheaterResponse toResponse(Theater theater) {

        return new TheaterResponse(
                theater.getName(),
                theater.getAddress(),
                theater.getCity(),
                theater.getLandmark()
        );
    }
}
