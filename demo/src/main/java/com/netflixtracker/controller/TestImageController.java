package com.netflixtracker.controller;

import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestImageController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/test-images")
    public String testImages() {
        var movies = movieService.getAllMovies();
        StringBuilder result = new StringBuilder("Image URLs:\n");
        
        for (var movie : movies) {
            result.append(movie.getTitle()).append(" -> ").append(movie.getImageUrl()).append("\n");
        }
        
        return result.toString();
    }
}