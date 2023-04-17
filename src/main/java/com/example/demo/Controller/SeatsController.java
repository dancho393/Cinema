package com.example.demo.Controller;

import com.example.demo.CinemaRelated.Seats;
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
    @PostMapping("/create")
    public ResponseEntity create32Seats(@RequestParam Long id){
        int row=1;
        for(int i=1;i<33;i++)
        {
            if(row%8==0 && i!=32)
                row++;
            Seats s=new Seats();
            s.setMovie(id);
            //s.setRow();
            //Here set everytthing
            seatService.createSeat(s);
        }
      return  ResponseEntity.ok(null);
    }
}

