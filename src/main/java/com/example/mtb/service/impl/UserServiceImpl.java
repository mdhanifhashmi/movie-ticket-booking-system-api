package com.example.mtb.service.impl;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetail;
import com.example.mtb.enums.UserRole;
import com.example.mtb.exception.UserExistByEmailException;
import com.example.mtb.mapper.UserMapper;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetail saveUser(UserRegistrationRequest userRegistrationRequest) {
        boolean exists =userRepository.existsByEmail(userRegistrationRequest.email());
        if(exists) {
            throw new UserExistByEmailException("User already exist with this email");
        }
        UserDetail newUser;

        switch (userRegistrationRequest.userRole()){
            case USER -> newUser = new User();
            case THEATER_OWNER -> newUser = new TheaterOwner();
            default -> throw new IllegalArgumentException("Unsupported role: "+ userRegistrationRequest.userRole());
        }

        UserDetail user = userMapper.toEntity(newUser, userRegistrationRequest);

        return userRepository.save(user);
    }


}
