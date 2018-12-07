package com.example.demo;

import javax.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String realname;

    @ManyToMany(mappedBy = "cast")
    private Set<Movie> cast;
}
