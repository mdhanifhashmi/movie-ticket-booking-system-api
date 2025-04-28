package com.example.mtb.mapper;

import com.example.mtb.dto.screen.ScreenRequest;
import com.example.mtb.dto.screen.ScreenResponse;
import com.example.mtb.entity.Screen;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper  {
    public Screen toEntity(ScreenRequest screenRequest) {
        Screen newscreen = new Screen();
        newscreen.setScreenType(screenRequest.screenType());
        newscreen.setCapacity(screenRequest.capacity());
        newscreen.setNoOfRows(screenRequest.noOfRow());

        return newscreen;
    }


    public ScreenResponse toResponse(Screen screen) {
        return  new ScreenResponse(
                screen.getScreenId(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows(),
                screen.getSeats()
        );
    }
}
