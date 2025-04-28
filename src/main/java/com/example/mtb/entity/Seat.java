package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String seatId;

    private String seatName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;

    private boolean isDelete;
    private LocalDateTime deleteAt;

    private String createdBy;

}
