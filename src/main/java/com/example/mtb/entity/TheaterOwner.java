package com.example.mtb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater_owner")
public class TheaterOwner extends UserDetail {

    @OneToMany(mappedBy = "theaterOwner")
    List<Theater> theaters = new ArrayList<>();
}
