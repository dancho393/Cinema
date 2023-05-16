package com.example.demo.Repository;

import com.example.demo.CinemaRelated.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movies,Long> {
    @Query("SELECT m FROM Movies m WHERE m.hour = ?1 AND m.title=?2 AND m.date=?3")
       Movies findByHour(LocalTime hour, String name, Timestamp date);
    @Query("select m FROM Movies m WHERE m.poster!=null ")
    List getRealMovies();
    @Query("SELECT m FROM Movies m WHERE m.title LIKE %:contain% AND m.poster!=null")
    List<Movies> getSearchedMovies(@Param("contain") String contain);


}
