package com.example.mtb.repository;

import com.example.mtb.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserDetail, String> {
}
