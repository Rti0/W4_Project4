package com.example.project4.Repository;

import com.example.project4.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie getMovieByName(String name);
    List<Movie> getMoviesByDirectorId(Integer id);
    List<Movie> getMoviesByRatingGreaterThan(Integer rate);
    List<Movie> getMoviesByGenre(String genre);
    Movie getMovieById(Integer id);

}
