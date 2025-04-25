package com.example.mtb.service;

import com.example.mtb.dto.user.UserRegistrationRequest;
import com.example.mtb.dto.user.UserRequest;
import com.example.mtb.dto.user.UserResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.UserDetail;


public interface UserService
{

     UserResponse saveUser(UserRegistrationRequest userRegistrationRequest);

    UserRequest updateUserProfile(String email, UserRequest userRequest);


}
