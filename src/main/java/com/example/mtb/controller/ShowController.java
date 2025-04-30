package com.example.mtb.controller;

import com.example.mtb.dto.show.ShowRequest;
import com.example.mtb.dto.show.ShowResponse;
import com.example.mtb.entity.Show;
import com.example.mtb.service.ShowService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShowController {

    private final ShowService showService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/theaters/{theaterId}/screens/{screenId}/show")
    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(@PathVariable String theaterId, @PathVariable String screenId, @RequestBody @Valid ShowRequest showRequest){
        ShowResponse showResponse = showService.saveTheater(theaterId, screenId, showRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "Show Created successfully with seat names", showResponse);
    }


}
