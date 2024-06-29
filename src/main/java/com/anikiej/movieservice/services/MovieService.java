package com.anikiej.movieservice.services;

import com.anikiej.movieservice.models.Movie;
import com.anikiej.movieservice.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> get(Long id) {
        return movieRepository.findById(id);
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> update(Long id, Movie updatedMovie) {
        return movieRepository.findById(id).map(movie -> {
            movie.setName(updatedMovie.getName());
            movie.setCategory(updatedMovie.getCategory());
            movie.setYearReleased(movie.getYearReleased());
            return movieRepository.save(movie);
        });
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public void makeAvailable(Long id) {
        movieRepository.findById(id).ifPresent(movie -> {
            movie.setAvailable(true);
            movieRepository.save(movie);
        });
    }

    public void rent(Long id) {
        movieRepository.findById(id).ifPresent(movie -> {
            movie.setAvailable(false);
            movieRepository.save(movie);
        });
    }

}
