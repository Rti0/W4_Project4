package com.example.project4.Controller;


import com.example.project4.Model.Movie;
import com.example.project4.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Movie> movies=movieService.getAll();
        return ResponseEntity.status(200).body(movies);
    }


    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }



    @GetMapping("/search-name/{name}")
    public ResponseEntity searchByMovieName(@PathVariable String name){
        Movie movie=movieService.getMovieByName(name);
    return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-duration/{name}")
    public ResponseEntity getByDuration(@PathVariable String name){
        Movie movie=movieService.getMovieByName(name);
        return ResponseEntity.status(200).body(movieService.getMovieByDuration(name));
    }

    @GetMapping("/get-movie-director/{name}")
    public ResponseEntity getMoviesByDirector(@PathVariable String name){
        List<Movie>movies=movieService.getMoviesByDirector(name);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/get-rate/{name}")
    public ResponseEntity getMovieRate(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getMovieRate(name));
    }

    @GetMapping("/get-above-rate/{rate}")
    public ResponseEntity getMovieByRate(@PathVariable Integer rate){
        List<Movie>movies=movieService.getMovieByRate(rate);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/get-genre/{genre}")
    public ResponseEntity getMovieByGenre(@PathVariable String genre){
        List<Movie>movies=movieService.getMovieByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }


}
