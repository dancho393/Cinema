package com.example.demo.CinemaRelated;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "movies",schema = "cinema")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;
    @Column(name = "movie_title")
    private String title;

    @Column(name = "movie_price")
    private Long price;

    @Column(name = "movie_rated")
    private Long rated;

    @Column(name = "movie_released")
    private Long released;

    @Column(name = "movie_genre")
    private String genre;

    @Column(name = "movie_plot")
    private String plot;

    @Column(name = "movie_language")
    private String language;

    @Column(name = "movie_poster")
    private String poster;

    @Column(name = "movie_date")
    private Timestamp date;

    @Column(name = "movie_year")
    private Timestamp year;

    @Column(name = "movie_runtime")
    private Time runtime;

    @Column(name = "movie_hour")
    private Time hour;

}
