package com.example.demo.Services;

import com.example.demo.CinemaRelated.*;
import com.example.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketsService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketsService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    public List<Tickets> getAllTickets() {
        return ticketRepository.findAll();
    }

    public ArrayList<Tickets> createTicket(Tickets ticket) {
        ArrayList<Seats> seats= SelectedSeats.getSelectedSeats();
        ArrayList<Tickets> tickets=new ArrayList<>();
        for(int i=0;i<seats.size();i++)
        {
            ticket.setUser_id(CurrentUser.getCurrentUser().getId());
            ticket.setRow(seats.get(i).getRow());
            ticket.setPlace(seats.get(i).getColumn());
            ticketRepository.save(ticket);
            tickets.add(ticket);
        }

        return tickets;
    }
    public List getTicketsByUser(Long id){
        List tickets=ticketRepository.findAllByUser_id(id);
        return tickets;
    }

}
