package com.example.mtb.service.impl;

import com.example.mtb.entity.UserDetail;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetail saveUser(UserDetail userDetail) {




        return null;
    }
}
