package com.example.demo.CinemaRelated;

import java.util.ArrayList;

public class SelectedSeats {
      private static ArrayList<Seats> seats;
      private static ArrayList<Seats> selectedSeats;

    public static ArrayList<Seats> getCurrentSeats() {
        if (seats == null) {
            return null;
        }
        return seats;
    }
    public static ArrayList<Seats> getSelectedSeats() {
        if (seats == null) {
            return null;
        }
        return selectedSeats;
    }
    public static void setSelectedSeats(ArrayList<Seats> newSeats){
        selectedSeats=newSeats;
    }
    public static void setSeats(ArrayList<Seats> newSeats){
        seats=newSeats;
    }
}
