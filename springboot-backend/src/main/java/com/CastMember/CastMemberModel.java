package com.CastMember;

import com.Movie.MovieModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Connor Hunter        connh321@gmail.com
 * <p>
 * A model for a castMember in the castMember table
 */
@Entity
@Table(name = "cast_member")
public class CastMemberModel {

    //non-parameterized constructor
    public CastMemberModel() {
    }

    //parameterized constructor
    public CastMemberModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //N:M with Movie
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "castMemberModels")
    private Set<MovieModel> movieModels = new HashSet<>();

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmid")
    private Long cmid;


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    ///
    ///GETTERS AND SETTERS
    ///

    public Long getCmid() {
        return cmid;
    }

    public void setCmid(Long cmid) {
        this.cmid = cmid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<MovieModel> getMovieModels() {
        return movieModels;
    }

    public void setMovieModels(Set<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }
}
