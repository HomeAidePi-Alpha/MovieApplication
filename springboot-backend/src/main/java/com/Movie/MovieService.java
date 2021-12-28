package com.Movie;

import com.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author Connor Hunter        connh321@gmail.com
 *
 * A Movie service responsible for business logic and making calls so the data accessing repository and returning the
 * proper data.
 *
 */
@Service
public class MovieService {
    @Autowired // Injected Singleton
    private final MovieRepository movieRepository;

    //Constructor
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Gets all movies from the database
     *
     * @return A list of all movies
     */
    public List<MovieModel> getAllMovies() {
        return movieRepository.findAll(); // returns a list of movies
    }


    /**
     * Saves a new movie into the repository
     *
     * @param movie A given movie
     * @return a newly saved Movie
     */
    public MovieModel createMovie(MovieModel movie) {
        return movieRepository.save(movie);
    }


    /**
     * Gets a movie by mid and returns it
     *
     * @param mid A given mid
     * @return A movie, or an RNF Exception
     */
    public MovieModel getMovieById(Long mid) {
        return movieRepository.findById(mid)
                .orElseThrow(() -> new ResourceNotFoundException("Movie With the mid: " + mid + " does not exist!"));
    }


    /**
     * Updates a given movie by mid given some new details
     *
     * @param mid    A long mid
     * @param movieDetails A movie details
     * @return A movie, or an RNF exception
     */
    public MovieModel updateMovie(Long mid, MovieModel movieDetails) {
        MovieModel movie = movieRepository.findById(mid)
                .orElseThrow(() -> new ResourceNotFoundException("Movie With the mid: " + mid + " does not exist!"));

        movie.setGenre(movieDetails.getGenre());
        movie.setLength(movieDetails.getLength());
        movie.setTitle(movieDetails.getTitle());
        movie.setReleaseDate(movieDetails.getReleaseDate());

        return movieRepository.save(movie);
    }


    /**
     * Deletes a movie given a mid
     *
     * @param mid A long mid
     */
    public void deleteMovie(Long mid) {
        MovieModel movie = movieRepository.findById(mid)
                .orElseThrow(() -> new ResourceNotFoundException("Movie With the mid: " + mid + " does not exist!"));
        movieRepository.delete(movie);
    }

}
