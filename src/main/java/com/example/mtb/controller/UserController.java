package com.example.mtb.controller;

import com.example.mtb.dto.user.UserRegistrationRequest;
import com.example.mtb.dto.user.UserRequest;
import com.example.mtb.dto.user.UserResponse;
import com.example.mtb.entity.UserDetail;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequest userRegistrationRequest){

        UserResponse userResponse = userService.saveUser(userRegistrationRequest);

        return responseBuilder.Success(HttpStatus.CREATED, "User created successfully", userResponse);
    }

    @PutMapping("/users/profile")
    public ResponseEntity<ResponseStructure<UserRequest>> updateUser(@RequestParam email, @RequestParam userRequest){



    }

}
