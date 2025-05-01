package com.example.mtb.entity;

import com.example.mtb.enums.Certificate;
import com.example.mtb.enums.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.Duration;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "movie")
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id",nullable = false,updatable = false)
    private String movieId;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description")
    private String description;


    @ElementCollection
    private Set<String> castList;

    @Column(name = "runtime",nullable = false)
    private Duration runtime;

    @Column(name = "certificate",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Certificate certificate;

    @Column(name = "genre",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;
}
