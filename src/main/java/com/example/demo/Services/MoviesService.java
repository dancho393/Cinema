package com.example.demo.Services;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Users;
import com.example.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.MvcLink;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
    private final MovieRepository movieRepository;

    @Autowired
    public MoviesService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movies getMovie(Long id)
    {
        return movieRepository.findById(id).orElse(null);
    }
    public Movies createMovie(Movies movie) {

        return movieRepository.save(movie);
    }

}
