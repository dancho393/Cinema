package com.example.demo.CinemaRelated;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

    @Data
    @Entity
    @Table(name = "tickets",schema = "cinema")
    public class Tickets {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ticket_id")
        private long id;
        @Column(name = "user_id")
        private Long user_id;
        @Column(name = "ticket_row")
        private Long row;
        @Column(name = "ticket_column")
        private Long place;
        @Column(name = "ticket_price")
        private Float price;
        @Column(name = "movie_title")
        private String movie_title;
        @Column(name = "ticket_date")
        private Timestamp date;
        @Column(name = "ticket_hour")
        private Time hour;
    @Column(name = "ticket_num")
        private Long number;

    }
