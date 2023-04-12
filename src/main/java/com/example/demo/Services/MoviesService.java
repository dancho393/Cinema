package com.example.demo.Services;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Movies> getMoviesByTitle(String title) {
        List<Movies> movies = movieRepository.findAll();

       for(Movies m:movies)
           if(m.getTitle().contains(title))
               movies.remove(m);
       return movies;

    }
}

