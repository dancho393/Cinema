package com.example.demo.Repository;

import com.example.demo.CinemaRelated.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seats,Long> {

}
