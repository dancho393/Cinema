package com.example.demo.Controller;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.Services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;
    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Movies>> getAllMovies () {
        List<Movies> movies = moviesService.getAllMovies();
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Movies> getMovie(@PathVariable Long id)
    {
        Movies movie= moviesService.getMovie(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);

    }

    @PostMapping
    public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
        Movies savedMovie = moviesService.createMovie(movie);
        if (savedMovie == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }
}
