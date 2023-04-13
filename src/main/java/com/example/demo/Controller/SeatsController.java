package com.example.demo.Controller;

import com.example.demo.Services.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity getAllSeatsForMovie(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getAllSeatsForMovie(id));

    }
    @PostMapping
    public ResponseEntity create32Seats(Long id){
      return  null;
    }
}

