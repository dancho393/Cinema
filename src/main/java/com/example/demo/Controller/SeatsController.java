package com.example.demo.Controller;

import com.example.demo.Services.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatsController {
    private final SeatService seatService;

    public SeatsController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity getAllSeats()
    {
        return  ResponseEntity.ok(this.seatService.getAllSeats());
    }

    public ResponseEntity getAllSeatsForMovie(){
        //return seatService.getAllSeatsForMovie();
        return null;
    }
}

