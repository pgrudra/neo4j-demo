package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;


import java.util.List;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@Node
public class Person {
    @Id
    @GeneratedValue
    Long id;

    private String name;
    private int born;

    @Relationship(type = "ACTED_IN")
    private List<Movie> movies;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
