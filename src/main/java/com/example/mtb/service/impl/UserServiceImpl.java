package com.example.mtb.service.impl;

import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetail;
import com.example.mtb.enums.UserRole;
import com.example.mtb.exception.UserExistByEmailException;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetail saveUser(UserDetail userDetail) {
        boolean exists =userRepository.existsByEmail(userDetail.getEmail());
        if(exists) {
            throw new UserExistByEmailException("User already exist with this email");
        }
        UserDetail newUser;

        switch (userDetail.getUserRole()){
            case USER -> newUser = new User();
            case THEATER_OWNER -> newUser = new TheaterOwner();
            default -> throw new IllegalArgumentException("Unsupported role: "+ userDetail.getUserRole());
        }

        return copyUserDetail(newUser, userDetail);
    }

    private UserDetail copyUserDetail(UserDetail user, UserDetail source) {
        user.setUserRole(source.getUserRole());
        user.setUsername(source.getUsername());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        user.setCreatedAt(source.getCreatedAt());
        user.setPhoneNumber(source.getPhoneNumber());
        user.setUpdatedAt(source.getUpdatedAt());
        user.setDateOfBirth(source.getDateOfBirth());

        return userRepository.save(user);
    }


}
