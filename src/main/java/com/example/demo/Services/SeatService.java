package com.example.demo.Services;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Seats;
import com.example.demo.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seats> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seats getSeat(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seats createSeat(Seats seat) {

        return seatRepository.save(seat);
    }

    public List<Seats> getAllSeatsForMovie(Long id) {
        List<Seats> movieSeats = seatRepository.findAll();
        for (Seats s : movieSeats) {
            if (s.getMovie() != id) {
                {
                    movieSeats.remove(s);
                }
            }

        }
        return movieSeats;
    }
}
