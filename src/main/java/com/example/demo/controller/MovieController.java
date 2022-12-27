package com.example.demo.controller;

import com.example.demo.domain.Movie;
import com.example.demo.model.APIResponse;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/create")
    public ResponseEntity<APIResponse<Movie>> testMovieService(){
        try {
            Movie movie = movieService.createEntities();
            APIResponse<Movie> response = new APIResponse<Movie>("success",movie);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse<Movie> response = new APIResponse<Movie>(e.getMessage(),null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/get-by-title")
    public ResponseEntity<APIResponse<Movie>> getMovieByTitle(@RequestBody String title){
        try {
            Movie movie = movieService.getMovieByTitle(title);
            APIResponse<Movie> response = new APIResponse<Movie>("success",movie);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse<Movie> response = new APIResponse<Movie>(e.getMessage(),null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/get-by-partial-title")
    public ResponseEntity<APIResponse<List<Movie>>> getMovieByPartialTitle(@RequestBody String partialTitle){
        try {
            List<Movie> movies = movieService.getMovieByPartialTitle(partialTitle);
            APIResponse<List<Movie>> response = new APIResponse<List<Movie>>("success",movies);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse<List<Movie>> response = new APIResponse<List<Movie>>(e.getMessage(),null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movies")
    public ResponseEntity<APIResponse<List<Movie>>> getAllMovies(){
        try {
            List<Movie> movies = movieService.getAllMovies();
            APIResponse<List<Movie>> response = new APIResponse<List<Movie>>("success",movies);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse<List<Movie>> response = new APIResponse<List<Movie>>(e.getMessage(),null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-by-title")
    public ResponseEntity<APIResponse<Movie>> deleteMovieByTitle(@RequestBody String title){
        try {
            movieService.deleteMovieByTitle(title);
            APIResponse<Movie> response = new APIResponse<Movie>("success",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse<Movie> response = new APIResponse<Movie>(e.getMessage(),null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<APIResponse<Movie>> deleteAllMovies(){
        try {
            movieService.deleteAllMovies();
            APIResponse<Movie> response = new APIResponse<Movie>("success",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            APIResponse<Movie> response = new APIResponse<Movie>(e.getMessage(),null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
