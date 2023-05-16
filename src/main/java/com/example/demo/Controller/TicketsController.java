package com.example.demo.Controller;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Tickets;
import com.example.demo.CinemaRelated.Users;
import com.example.demo.Services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    private final TicketsService ticketsService;

    @Autowired
    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Tickets>> getAllUsers() {
        List<Tickets> tickets = ticketsService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity Create(@RequestBody Tickets ticket){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketsService.createTicket(ticket));
    }

    @GetMapping("/forUser")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getTicketsForUser(@RequestParam("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(ticketsService.getTicketsByUser(id));

    }


}
