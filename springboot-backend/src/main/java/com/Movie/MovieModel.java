package com.Movie;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

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

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Long mid;

    @NotNull
    @Column(name = "title")
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
}