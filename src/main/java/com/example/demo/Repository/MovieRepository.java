package com.example.demo.Repository;

import com.example.demo.CinemaRelated.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movies,Long> {
}
