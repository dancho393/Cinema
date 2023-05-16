package com.example.demo.Controller;

import com.example.demo.CinemaRelated.Seats;
import com.example.demo.CinemaRelated.SelectedSeats;
import com.example.demo.Services.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getAllSeatsForMovie(@RequestParam Long id){
        return ResponseEntity.ok(seatService.getAllSeatsForMovie(id));

    }
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity create32Seats(@RequestParam Long id) {
        int row = 1;
        ArrayList<Seats> seats=new ArrayList<>();
        for (int i = 1; i < 33; i++) {

            Seats s = new Seats();
            s.setMovie(id);
            s.setRow(Long.valueOf(row));
            s.setColumn(Long.valueOf(i));
            s.setFree(Long.valueOf(0));
            seatService.createSeat(s);
            seats.add(s);
            if (i % 8 == 0) {
                row++;
            }
        }
        SelectedSeats.setSeats(seats);
        return ResponseEntity.ok(row);
    }
    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity update(){
        ArrayList<Seats> selectedSeats=SelectedSeats.getSelectedSeats();
        for(int i=0;i<selectedSeats.size();i++) {
            seatService.updateSeat(selectedSeats.get(i));
        }


        return ResponseEntity.status(HttpStatus.FOUND).body(SelectedSeats.getCurrentSeats());

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/setSelectedSeats")
    public ResponseEntity setSelectedSeats(@RequestParam("nums") ArrayList<Integer> nums){
        seatService.setSelectedSeats(nums);
        return ResponseEntity.ok(SelectedSeats.getSelectedSeats());
    }
}

