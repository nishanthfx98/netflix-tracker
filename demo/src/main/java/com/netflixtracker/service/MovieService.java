package com.netflixtracker.service;

import com.netflixtracker.model.Movie;
import com.netflixtracker.repository.MovieRepository;
import com.netflixtracker.repository.WatchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private WatchHistoryRepository watchHistoryRepository;
    
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    
    public List<Movie> getTopRatedMovies() {
        return movieRepository.findTopRatedMovies();
    }
    
    public void updateMovieRating(Long movieId) {
        Movie movie = getMovieById(movieId);
        if (movie != null) {
            List<Object[]> ratings = watchHistoryRepository.findByMovieMovieId(movieId)
                .stream()
                .map(wh -> new Object[]{wh.getRating()})
                .toList();
            
            if (!ratings.isEmpty()) {
                double avgRating = ratings.stream()
                    .mapToDouble(r -> (Integer) r[0])
                    .average()
                    .orElse(0.0);
                movie.setRatingAvg((float) avgRating);
                movieRepository.save(movie);
            }
        }
    }
    
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    public List<Object[]> getTop5WatchedMovies() {
        return watchHistoryRepository.findTopWatchedMovies().stream().limit(5).toList();
    }
}