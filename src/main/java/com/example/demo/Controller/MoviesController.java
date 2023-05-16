package com.example.demo.Controller;

import com.example.demo.CinemaRelated.CurrentUser;
import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Seats;
import com.example.demo.CinemaRelated.SelectedSeats;
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

    //Search Bar
    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Movies>> getMovie(@RequestParam("contains") String title)
    {
        return  ResponseEntity.ok(moviesService.SearchBar(title));

    }
    @GetMapping("/byTime")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Movies> MyGetter(@RequestParam("hour") LocalTime hour,
                                           @RequestParam("name")String name,
                                           @RequestParam("date") Timestamp date)
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
    @GetMapping("/real")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity realMovies(){
        SelectedSeats.setSelectedSeats(null);
        SelectedSeats.setSeats(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(moviesService.getRealMovies());
    }


}
