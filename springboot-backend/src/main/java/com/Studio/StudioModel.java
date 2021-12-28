package com.Studio;

import com.Movie.MovieModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Connor Hunter        connh321@gmail.com
 * <p>
 * A model for a studio in the studio table
 */
@Entity
@Table(name = "studio")
public class StudioModel {

    //non-parameterized constructor
    public StudioModel() {
    }

    //parameterized constructor
    public StudioModel(String name) {
        this.name = name;
    }

    //N:M with Movie
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studioModels")
    private Set<MovieModel> movieModels = new HashSet<>();

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Long sid;

    @Column(name = "name", nullable = false)
    private String name;

    ///
    ///GETTERS AND SETTERS
    ///

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MovieModel> getMovieModels() {
        return movieModels;
    }

    public void setMovieModels(Set<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }
}
