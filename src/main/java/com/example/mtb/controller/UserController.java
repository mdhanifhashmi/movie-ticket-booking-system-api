package com.example.mtb.controller;

import com.example.mtb.dto.user.UserRegistrationRequest;
import com.example.mtb.dto.user.UserRequest;
import com.example.mtb.dto.user.UserResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){

        UserResponse userResponse = userService.saveUser(userRegistrationRequest);

        return responseBuilder.success(HttpStatus.CREATED, "User created successfully", userResponse);
    }

    @PutMapping("/users")
    public ResponseEntity<ResponseStructure<UserRequest>> updateUser(
            @RequestParam String email, @RequestBody @Valid UserRequest userRequest){

        UserRequest userRequest1 = userService.updateUserProfile(email, userRequest);
         return  responseBuilder.success(HttpStatus.OK, "User updates successfully", userRequest1 );
    }


}
