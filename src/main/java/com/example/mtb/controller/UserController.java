package com.example.mtb.controller;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.entity.UserDetail;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserDetail>> addUser(@RequestBody UserRegistrationRequest userRegistrationRequest){

        UserDetail userDetail1= userService.saveUser(userRegistrationRequest);
        return responseBuilder.Success(HttpStatus.CREATED, "User created successfully", userDetail1);
    }

}
