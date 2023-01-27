package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    String addMovieDirectorPair(String movieName, String directorName){
        return movieRepository.addMovieDirectorPair(movieName,directorName);
    }

    Movie getMovieByName(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    List<String> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }

}
