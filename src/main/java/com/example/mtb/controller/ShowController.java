package com.example.mtb.controller;

import com.example.mtb.dto.show.ShowResponse;
import com.example.mtb.service.ShowService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@AllArgsConstructor
public class ShowController {

    private final ShowService showService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/theaters/{theaterId}/screens/{screenId}/show")
    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(@PathVariable String theaterId, @PathVariable String screenId,
                                                                   @RequestParam String movieId,
                                                                   @RequestParam Long statsAt){
        ShowResponse showResponse = showService.saveShow(theaterId, screenId, movieId, statsAt);
        return restResponseBuilder.success(HttpStatus.CREATED, "Show Created successfully with seat names", showResponse);
    }


}
