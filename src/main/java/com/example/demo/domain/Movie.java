package com.example.demo.domain;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;





@Setter
@Node
public class Movie {

    @Id
    @GeneratedValue
    Long id;

    private String title;

    private int released;

    private String tagline;

    @Relationship(type="ACTED_IN", direction = Relationship.Direction.INCOMING)

    private List<Role> roles;

    // standard constructor, getters and setters
}
