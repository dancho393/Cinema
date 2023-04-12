package com.example.demo.CinemaRelated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "seats", schema = "cinema")
public class Seats {
    @Id
    @Column(name = "seat_id")
    private long id;
    @Column(name = "seat_column")
    private  Long column;
    @Column(name = "seat_row")
    private Long row;
    @Column(name = "seat_free")
    private Long free;
    @Column(name = "seat_movie")
    private Long movie;
    @Column(name = "seat_userid")
    private Long user;
}
