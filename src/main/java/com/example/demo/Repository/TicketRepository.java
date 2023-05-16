package com.example.demo.Repository;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Seats;
import com.example.demo.CinemaRelated.Tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Tickets,Long> {
    @Query("SELECT t FROM Tickets t WHERE t.user_id = ?1")
    List findAllByUser_id(long id);
}
