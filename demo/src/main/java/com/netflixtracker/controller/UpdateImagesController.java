package com.netflixtracker.controller;

import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateImagesController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/update-images")
    public String updateImages() {
        var movies = movieService.getAllMovies();
        
        for (var movie : movies) {
            String imageName = movie.getTitle().toLowerCase()
                .replace(" ", "_")
                .replace(":", "")
                .replace("'", "");
            movie.setImageUrl("/assets/" + imageName + ".jpg");
            movieService.saveMovie(movie);
        }
        
        return "Updated " + movies.size() + " movie images";
    }
}