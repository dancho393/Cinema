package com.example.demo.CinemaRelated;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "movies",schema = "cinema")
public class Movies {
    @Id
    @Column(name = "movie_id")
    private long id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_date")
    private Timestamp date;
    @Column(name = "movie_duration")
    private Time duration;
    @Column(name = "movie_price")
    private float price;

}
