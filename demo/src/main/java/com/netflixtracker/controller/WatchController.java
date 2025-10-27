package com.netflixtracker.controller;

import com.netflixtracker.model.WatchHistory;
import com.netflixtracker.service.UserService;
import com.netflixtracker.service.MovieService;
import com.netflixtracker.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watch")
public class WatchController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private MovieService movieService;
    
    @Autowired
    private WatchHistoryService watchHistoryService;

    @PostMapping("/{movieId}")
    public String watchMovie(@PathVariable Long movieId, @RequestParam Integer rating, Authentication auth) {
        try {
            String email = auth.getName();
            var user = userService.getUserByEmail(email);
            var movie = movieService.getMovieById(movieId);
            
            if (user != null && movie != null) {
                WatchHistory watchHistory = new WatchHistory(user, movie, rating);
                watchHistoryService.saveWatchHistory(watchHistory);
                return "Movie watched and rated successfully!";
            }
            return "Error: User or movie not found";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}