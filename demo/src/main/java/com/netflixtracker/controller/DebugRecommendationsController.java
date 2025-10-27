package com.netflixtracker.controller;

import com.netflixtracker.service.RecommendationService;
import com.netflixtracker.service.UserService;
import com.netflixtracker.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugRecommendationsController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private WatchHistoryService watchHistoryService;
    
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/debug/recommendations")
    public String debugRecommendations(Authentication auth) {
        String email = auth.getName();
        var user = userService.getUserByEmail(email);
        
        if (user == null) {
            return "User not found";
        }
        
        var history = watchHistoryService.getWatchHistoryByUser(user.getUserId());
        var recommendations = recommendationService.getRecommendedMovies(user.getUserId());
        
        StringBuilder result = new StringBuilder();
        result.append("User: ").append(user.getName()).append("\n");
        result.append("Watch History Count: ").append(history.size()).append("\n\n");
        
        result.append("Watch History:\n");
        for (var h : history) {
            result.append("- ").append(h.getMovie().getTitle())
                  .append(" (").append(h.getMovie().getGenre()).append(") - Rating: ")
                  .append(h.getRating()).append("\n");
        }
        
        result.append("\nRecommendations Count: ").append(recommendations.size()).append("\n");
        result.append("Recommendations:\n");
        for (var movie : recommendations) {
            result.append("- ").append(movie.getTitle())
                  .append(" (").append(movie.getGenre()).append(")\n");
        }
        
        return result.toString();
    }
}