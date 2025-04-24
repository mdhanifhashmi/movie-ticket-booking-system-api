package com.example.mtb.mapper;

import com.example.mtb.dto.user.UserRegistrationRequest;
import com.example.mtb.dto.user.UserResponse;
import com.example.mtb.entity.UserDetail;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDetail toEntity(UserDetail user, UserRegistrationRequest source) {
        user.setUserRole(source.userRole());
        user.setUsername(source.username());
        user.setEmail(source.email());
        user.setPassword(source.password());
        user.setPhoneNumber(source.phoneNumber());
        user.setDateOfBirth(source.dateOfBirth());

        return user;
    }

    public UserResponse toResponse(UserDetail userDetail) {

        return new UserResponse(
                userDetail.getUserId(),
                userDetail.getUsername(),
                userDetail.getEmail(),
                userDetail.getPhoneNumber(),
                userDetail.getDateOfBirth(),
                userDetail.getUserRole()
        );
    }
}
