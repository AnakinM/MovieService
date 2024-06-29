package com.anikiej.movieservice.repositories;

import com.anikiej.movieservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
