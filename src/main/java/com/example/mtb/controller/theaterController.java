package com.example.mtb.controller;

import com.example.mtb.dto.theater.TheaterRequest;
import com.example.mtb.dto.theater.TheaterResponse;
import com.example.mtb.service.TheaterService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class theaterController {

    private final TheaterService theaterService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/theaters")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(@RequestParam String email, @RequestBody @Valid TheaterRequest theaterRequest) {
        TheaterResponse theaterResponse = theaterService.saveTheater(email, theaterRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "Theater created Successfully", theaterResponse);

    }

}

