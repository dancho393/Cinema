package com.example.demo.Controller;

import com.example.demo.Repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MovieRepository movieRepository;

    public MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping
    public ResponseEntity getAllMovies(){
        return ResponseEntity.ok(movieRepository.findAll());
    }
}
