package com.netflixtracker.service;

import com.netflixtracker.model.WatchHistory;
import com.netflixtracker.repository.WatchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WatchHistoryService {
    
    @Autowired
    private WatchHistoryRepository watchHistoryRepository;
    
    @Autowired
    private MovieService movieService;
    
    public WatchHistory saveWatchHistory(WatchHistory watchHistory) {
        WatchHistory saved = watchHistoryRepository.save(watchHistory);
        movieService.updateMovieRating(watchHistory.getMovie().getMovieId());
        return saved;
    }
    
    public List<WatchHistory> getWatchHistoryByUser(Long userId) {
        return watchHistoryRepository.findByUserUserId(userId);
    }
    
    public List<WatchHistory> getWatchHistoryByMovie(Long movieId) {
        return watchHistoryRepository.findByMovieMovieId(movieId);
    }
    
    public List<Object[]> getTopWatchedMovies() {
        return watchHistoryRepository.findTopWatchedMovies();
    }
}