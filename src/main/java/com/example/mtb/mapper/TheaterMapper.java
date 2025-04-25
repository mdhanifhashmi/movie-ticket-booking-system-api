package com.example.mtb.mapper;

import com.example.mtb.dto.theater.TheaterRequest;
import com.example.mtb.dto.theater.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {
    public Theater toEntity(TheaterRequest theaterRequest) {
        Theater newTheater = new Theater();

        newTheater.setName(theaterRequest.name());
        newTheater.setAddress(theaterRequest.address());
        newTheater.setCity(theaterRequest.city());
        newTheater.setLandmark(theaterRequest.landmark());

        return  newTheater;
    }

    public void toEntity(TheaterRequest source, Theater theater) {
        theater.setName(source.name());
        theater.setAddress(source.address());
        theater.setCity(source.city());
        theater.setLandmark(source.landmark());
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
