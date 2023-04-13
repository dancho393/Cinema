package com.example.demo.Services;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public MoviesService(MovieRepository movieRepository, SeatRepository seatRepository) {
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
    }

    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movies getMovie(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movies createMovie(Movies movie) {

        return movieRepository.save(movie);
    }
    public Movies getMoviebyHourAndDate(LocalTime hour, String name, Timestamp date){
        Movies movie = movieRepository.findByHour(hour,name,date);

        if (movie == null) {
            return null;
        }

        return movie;


    }

    public List<Movies> getMoviesByTitle(String title) {
        List<Movies> movies = movieRepository.findAll();

       for(Movies m:movies)
           if(m.getTitle().contains(title))
               movies.remove(m);
       return movies;

    }
}

