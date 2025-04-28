package com.example.mtb.entity;

import com.example.mtb.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Screen {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String screenId;
    private ScreenType screenType;

    @ManyToOne
    private Theater theater;

    private int capacity;
    private int noOfRows;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;

    @OneToMany(mappedBy = "screen", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<Seat> seats = new ArrayList<>();

}
