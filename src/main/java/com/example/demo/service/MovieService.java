package com.example.demo.service;

import com.example.demo.domain.Movie;
import com.example.demo.domain.Person;
import com.example.demo.domain.Role;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    PersonRepository personRepository;
    public Movie createEntities(){
        Movie movie = createMovie();
        Person person = createPerson();
        return createRole(movie,person);
    }

    public Movie getMovieByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getMovieByPartialTitle(String partialTitle){
        return movieRepository.findByTitleContaining(partialTitle).stream().toList();
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    private Movie createRole(Movie movie, Person person) {
        Role arjun = new Role();
        arjun.setMovie(movie);
        arjun.setPerson(person);
        Collection<String> roleNames = new HashSet();
        roleNames.add("Arjuna");
        arjun.setRoles(roleNames);
        List<Role> roles = new ArrayList();
        roles.add(arjun);
        movie.setRoles(roles);
        return movieRepository.save(movie);
    }

    private Person createPerson() {
        Person mark = new Person();
        mark.setName("Prajwal");
        return personRepository.save(mark);
    }

    private Movie createMovie() {
        Movie italianJob = new Movie();
        italianJob.setTitle("Big Bull");
        italianJob.setReleased(2020);
        return movieRepository.save(italianJob);
    }

    public void deleteMovieByTitle(String title){
        movieRepository.delete(movieRepository.findByTitle(title));
    }

    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }
}
