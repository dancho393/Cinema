package com.example.demo.Services;

import com.example.demo.CinemaRelated.Movies;
import com.example.demo.CinemaRelated.Seats;
import com.example.demo.CinemaRelated.SelectedSeats;
import com.example.demo.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Seats> iterator = movieSeats.iterator();
        while (iterator.hasNext()) {
            Seats s = iterator.next();
            if (s.getMovie() != id) {
                iterator.remove();
            }
        }
        ArrayList<Seats> s=new ArrayList<>(movieSeats);
        SelectedSeats.setSeats(s);
        return movieSeats;
    }
    public Seats updateSeat(Seats s){

     if(s.getFree()==0){
         s.setFree(((long)1));
     }
         else if(s.getFree()==1){
         s.setFree(((long)0));
     }

     return seatRepository.save(s);
    }
    public void setSelectedSeats(ArrayList<Integer> nums){
        ArrayList<Seats> selectedSeats=new ArrayList<>();
        ArrayList<Seats> list=SelectedSeats.getCurrentSeats();
        for(int i=0;i<nums.size();i++){
            selectedSeats.add(list.get(nums.get(i)-1));
        }
        SelectedSeats.setSelectedSeats(selectedSeats);

    }

}
