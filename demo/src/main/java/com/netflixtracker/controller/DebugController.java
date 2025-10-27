package com.netflixtracker.controller;

import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/debug/movies")
    public String debugMovies() {
        var movies = movieService.getAllMovies();
        return "Total movies in database: " + movies.size() + 
               "\nMovies: " + movies.stream()
                   .map(m -> m.getTitle() + " (" + m.getGenre() + ")")
                   .reduce("", (a, b) -> a + "\n" + b);
    }
}