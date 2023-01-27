package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

//    Add a movie: POST /movies/add-movie
//    Pass the Movie object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovie
    @PostMapping("movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

//    Add a director: POST /movies/add-director
//    Pass the Director object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addDirector
    @PostMapping("movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director), HttpStatus.CREATED);
    }
//    Pair an existing movie and director: PUT /movies/add-movie-director-pair
//    Pass movie name and director name as request parameters
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovieDirectorPair
    @PutMapping("movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movie,director), HttpStatus.CREATED);
    }
//    Get Movie by movie name: GET /movies/get-movie-by-name/{name}
//    Pass movie name as path parameter
//    Return Movie object wrapped in a ResponseEntity object
//    Controller Name - getMovieByName

    @GetMapping("movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam String movie){
        return new ResponseEntity<>(movieService.getMovieByName(movie), HttpStatus.FOUND);
    }
//    Get Director by director name: GET /movies/get-director-by-name/{name}
//    Pass director name as path parameter
//    Return Director object wrapped in a ResponseEntity object
//    Controller Name - getDirectorByName
    @GetMapping("movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam String director){
        return new ResponseEntity<>(movieService.getDirectorByName(director), HttpStatus.FOUND);
    }
//    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
//    Pass director name as path parameter
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - getMoviesByDirectorName
    @GetMapping("movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathParam String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.FOUND);
    }
//    Get List of all movies added: GET /movies/get-all-movies
//    No params or body required
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - findAllMovies
    @GetMapping("movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.FOUND);
    }
//    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
//    Pass director’s name as request parameter
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteDirectorByName
    @DeleteMapping("movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String director){
        return new ResponseEntity<>(movieService.deleteDirectorByName(director), HttpStatus.OK);
    }
//    Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
//    No params or body required
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteAllDirectors
//            (Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }

}
