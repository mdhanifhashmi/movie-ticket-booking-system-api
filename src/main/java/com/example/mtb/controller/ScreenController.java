package com.example.mtb.controller;

import com.example.mtb.dto.screen.ScreenRequest;
import com.example.mtb.dto.screen.ScreenResponse;
import com.example.mtb.entity.Screen;
import com.example.mtb.service.ScreenService;
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
public class ScreenController {

    private final ScreenService screenService;
    private final RestResponseBuilder restResponseBuilder;

    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    @PostMapping("/theaters/{theaterId}/Screens")
    public ResponseEntity<ResponseStructure<ScreenResponse>> saveScreen (@PathVariable String theaterId, @RequestBody @Valid ScreenRequest screenRequest){
        ScreenResponse screenResponse = screenService.saveScreen(theaterId, screenRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "Screen Created successfully with seat names", screenResponse );
    }

    @GetMapping("theaters/{theaterId}/screens/{screenId}")
    public ResponseEntity<ResponseStructure<ScreenResponse>> findScreen(@PathVariable String theaterId, @PathVariable String screenId){
        ScreenResponse screenResponse = screenService.findScreen(theaterId, screenId);
        return restResponseBuilder.success(HttpStatus.FOUND, "Screen has been fetch successfully", screenResponse);

    }


}
