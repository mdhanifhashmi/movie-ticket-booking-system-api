package com.example.mtb.entity;

import com.example.mtb.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.security.PrivateKey;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "screen")
public class Screen {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    @Column(name = "screen_id", updatable = false, nullable = false)
    private String screenId;

    @Column(name = "screen_type")
    private ScreenType screenType;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "no_of_rows")
    private int noOfRows;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    @OneToMany(mappedBy = "screen", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<Seat> seats = new ArrayList<>();

}
