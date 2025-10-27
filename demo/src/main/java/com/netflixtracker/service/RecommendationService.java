package com.netflixtracker.service;

import com.netflixtracker.model.Movie;
import com.netflixtracker.model.WatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private WatchHistoryService watchHistoryService;
    
    @Autowired
    private MovieService movieService;

    public List<Movie> getRecommendedMovies(Long userId) {
        // Get user's watch history
        List<WatchHistory> userHistory = watchHistoryService.getWatchHistoryByUser(userId);
        
        // If no watch history, return popular movies
        if (userHistory.isEmpty()) {
            return movieService.getAllMovies().stream().limit(5).collect(Collectors.toList());
        }
        
        // Get user's favorite genres (from highly rated movies)
        List<String> highRatedGenres = userHistory.stream()
            .filter(wh -> wh.getRating() >= 4)
            .map(wh -> wh.getMovie().getGenre())
            .distinct()
            .collect(Collectors.toList());
        
        // Use highly rated genres, or all genres if none are highly rated
        List<String> favoriteGenres = highRatedGenres.isEmpty() ? 
            userHistory.stream()
                .map(wh -> wh.getMovie().getGenre())
                .distinct()
                .collect(Collectors.toList()) : highRatedGenres;
        
        // Get watched movie IDs
        List<Long> watchedMovieIds = userHistory.stream()
            .map(wh -> wh.getMovie().getMovieId())
            .collect(Collectors.toList());
        
        // Find movies in favorite genres that user hasn't watched
        return movieService.getAllMovies().stream()
            .filter(movie -> favoriteGenres.contains(movie.getGenre()))
            .filter(movie -> !watchedMovieIds.contains(movie.getMovieId()))
            .limit(5)
            .collect(Collectors.toList());
    }
}