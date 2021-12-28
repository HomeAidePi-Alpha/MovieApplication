package com.Movie;


import com.CastMember.CastMemberModel;
import com.Director.DirectorModel;
import com.Studio.StudioModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Connor Hunter        connh321@gmail.com
 * <p>
 * A model for a movie in the movie table
 */
@Entity
@Table(name = "movie")
public class MovieModel {

    //non-parameterized constructor
    public MovieModel() {
    }

    //parameterized constructor
    public MovieModel(String title, String length, String genre, Date releaseDate) {
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    //N:M with Director
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_director",
            joinColumns = {@JoinColumn(name = "mid")},
            inverseJoinColumns = {@JoinColumn(name = "did")}
    )
    private Set<DirectorModel> directorModels = new HashSet<>();

    //N:M with CastMember
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_cast_member",
            joinColumns = {@JoinColumn(name = "mid")},
            inverseJoinColumns = {@JoinColumn(name = "cmid")}
    )
    private Set<CastMemberModel> castMemberModels = new HashSet<>();

    //N:M with Studio
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_studio",
            joinColumns = {@JoinColumn(name = "mid")},
            inverseJoinColumns = {@JoinColumn(name = "sid")}
    )
    private Set<StudioModel> studioModels = new HashSet<>();

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Long mid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "length")
    private String length;

    @Column(name = "genre")
    private String genre;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    ///
    ///GETTERS AND SETTERS
    ///

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<DirectorModel> getDirectorModels() {
        return directorModels;
    }

    public void setDirectorModels(Set<DirectorModel> directorModels) {
        this.directorModels = directorModels;
    }

    public Set<CastMemberModel> getCastMemberModels() {
        return castMemberModels;
    }

    public void setCastMemberModels(Set<CastMemberModel> castMemberModels) {
        this.castMemberModels = castMemberModels;
    }

    public Set<StudioModel> getStudioModels() {
        return studioModels;
    }

    public void setStudioModels(Set<StudioModel> studioModels) {
        this.studioModels = studioModels;
    }
}