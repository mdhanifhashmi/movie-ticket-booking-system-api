package com.example.mtb.service;

import com.example.mtb.entity.UserDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface UserService
{

     UserDetail saveUser(UserDetail userDetail);
}
