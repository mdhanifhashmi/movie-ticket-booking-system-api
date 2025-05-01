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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class theaterController {

    private final TheaterService theaterService;
    private final RestResponseBuilder restResponseBuilder;

    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    @PostMapping("/theaters")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(@RequestParam String email, @RequestBody @Valid TheaterRequest theaterRequest) {
        TheaterResponse theaterResponse = theaterService.saveTheater(email, theaterRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "Theater created Successfully", theaterResponse);

    }

    @GetMapping("theater/{theaterId}")
    public ResponseEntity<ResponseStructure<TheaterResponse>> findTheater(@PathVariable String theaterId){
        TheaterResponse theaterResponse = theaterService.findTheater(theaterId);
        return restResponseBuilder.success(HttpStatus.FOUND, "theater found in database", theaterResponse);
    }

    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    @PutMapping("/theater/{theaterId}")
    public ResponseEntity<ResponseStructure<TheaterResponse>> updateTheater(@PathVariable String theaterId, @RequestBody TheaterRequest theaterRequest){
        TheaterResponse theaterResponse = theaterService.updateTheater(theaterId, theaterRequest);
        return restResponseBuilder.success(HttpStatus.OK, "Theater details scuccessfully updates", theaterResponse);
    }

}

