package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;

    @ManyToOne
    private TheaterOwner theaterOwner;

    private String name;
    private String address;
    private String city;
    private String landmark;
    private Long createdAt;
    private Long updateAt;
    private String createBy;
}
