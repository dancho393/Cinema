package com.example.demo.Controller;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.Services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalTime;
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

    @GetMapping("/{title}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Movies>> getMovie(@PathVariable String title)
    {
        return  ResponseEntity.ok(moviesService.getMoviesByTitle(title));

    }
    @GetMapping("/byHour")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Movies> MyGetter(@RequestParam("hour") LocalTime hour,@RequestParam("name")String name,@RequestParam("date") Timestamp date)
    {

        return ResponseEntity.ok(moviesService.getMoviebyHourAndDate(hour,name,date));
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
        Movies savedMovie = moviesService.createMovie(movie);
        if (savedMovie == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }
}
