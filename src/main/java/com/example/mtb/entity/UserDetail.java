package com.example.mtb.entity;

import com.example.mtb.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Setter
@Getter
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    private String email;
    private String password;
    private UserRole userRole;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private long createdAt;
    private long updatedAt;

}
