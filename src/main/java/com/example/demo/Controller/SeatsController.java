package com.example.demo.Controller;

import com.example.demo.Repository.SeatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatsController {
    private final SeatRepository seatRepository;

    public SeatsController(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
    @GetMapping
    public ResponseEntity getAllSeats()
    {
        return  ResponseEntity.ok(this.seatRepository.findAll());
    }
}

