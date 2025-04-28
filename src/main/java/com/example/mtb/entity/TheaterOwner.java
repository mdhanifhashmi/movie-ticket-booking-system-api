package com.example.mtb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TheaterOwner extends UserDetail {

    @OneToMany(mappedBy = "theaterOwner")
    List<Theater> theaters = new ArrayList<>();
}
