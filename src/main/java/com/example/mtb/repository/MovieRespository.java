package com.example.mtb.repository;

import com.example.mtb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRespository extends JpaRepository<Movie, String> {
}
