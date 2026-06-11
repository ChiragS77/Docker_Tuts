package com.cinema.controller;

import com.cinema.entity.Movie;
import com.cinema.repository.MovieReopository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {


    private final MovieReopository repository;


    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = repository.save(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    // 2. GET ALL API - Retrieve all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = repository.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
