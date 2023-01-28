package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String,Movie> movieMap = new HashMap<>();
    Map<String,Director> directorMap = new HashMap<>();
    Map<String, List<String>> dmPair = new HashMap<>();

    public String addMovie(Movie movie){
        if(movie==null) return "Something Went Wrong";
        movieMap.put(movie.getName(),movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director){
        if(director==null) return "Something Went Wrong";
        directorMap.put(director.getName(),director);
        return "Director Added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)){
            if(dmPair.containsKey(directorName)){
                dmPair.get(directorName).add(movieName);
            }else{
                List<String> ls = new ArrayList<>();
                ls.add(movieName);
                dmPair.put(directorName,ls);
            }
            return "Pair Added Successfully";
        }
        return "Something Went Wrong";
    }

    public Movie getMovieByName(String movieName){
        return movieMap.get(movieName);
    }

    Director getDirectorByName(String directorName){
        return directorMap.get(directorName);
    }

    List<String> getMoviesByDirectorName(String directorName){
        return dmPair.get(directorName);
    }

    List<String> findAllMovies(){
        List<String> allMovies = List.copyOf(movieMap.keySet());
        return allMovies;
    }

    public String deleteDirectorByName(String directorName){
        if(dmPair.containsKey(directorName)){
            dmPair.remove(directorName);
            return "Deleted Suceessfully";
        }else{
            return "Not Found";
        }
    }

    public String deleteAllDirectors(){
//        for(List<String> ls:dmPair.values()){
//            for(String movieName : ls){
//                    movieMap.remove(movieName);
//            }
//        }
        dmPair.clear();
        directorMap.clear();
        return "Removed Successfully";
    }
}
