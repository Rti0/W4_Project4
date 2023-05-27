package com.example.project4.Service;


import com.example.project4.ApiException.ApiException;
import com.example.project4.Model.Movie;
import com.example.project4.Repository.DirectorRepository;
import com.example.project4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }
 public void addMovie(Movie movie){
        movieRepository.save(movie);
 }
public void updateMovie(Integer id, Movie movie){
        Movie old=movieRepository.getMovieById(id);
        if (old==null){
            throw new ApiException("The Movie does not exist");
        }
        old.setId(movie.getId());
        old.setName(movie.getName());
        old.setGenre(movie.getGenre());
        old.setRating(movie.getRating());
        old.setDuration(movie.getDuration());
        old.setDirectorId(movie.getDirectorId());
        movieRepository.save(old);
}
public void deleteMovie(Integer id){
      Movie old=movieRepository.getMovieById(id);
      if (old==null){
          throw new ApiException("Wrong Deleted");
      }
      movieRepository.delete(old);
}

    public Movie getMovieByName(String name){
        Movie movie=movieRepository.getMovieByName(name);
        if (movie==null){
            throw new ApiException("Not Found");
        }
        return movie;
        }


    public Integer getMovieByDuration(String name){
      return  movieRepository.getMovieByName(name).getDuration();
    }

    public List<Movie> getMoviesByDirector(String name){
        List <Movie>movies=movieRepository.getMoviesByDirectorId(directorService.getDirectorByName(name).getId());
        if (movies==null){
            throw new ApiException("Not Found");
        }
        return movies;
    }

    public Integer getMovieRate(String name){
        return movieRepository.getMovieByName(name).getRating();
    }

    public List<Movie> getMovieByRate(Integer rate){
        List<Movie>movies=movieRepository.getMoviesByRatingGreaterThan(rate);
        if (movies==null){
            throw new ApiException("Not Found");
        }
        return movies;
    }

    public List<Movie> getMovieByGenre(String genre){
        List<Movie>movies=movieRepository.getMoviesByGenre(genre);
        if (movies==null){
            throw new ApiException("Not Found");
        }
        return movies;
    }

}
