package com.example.demo.Repository;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;
import java.time.LocalTime;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seats,Long> {


}
