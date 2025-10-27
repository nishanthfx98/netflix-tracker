package com.netflixtracker.controller;

import com.netflixtracker.model.Movie;
import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String manageMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin/movies";
    }

    @GetMapping("/movies/add")
    public String addMovieForm() {
        return "admin/add-movie";
    }

    @PostMapping("/movies/add")
    public String addMovie(@RequestParam String title, @RequestParam String genre,
                          @RequestParam Integer releaseYear, @RequestParam Integer duration,
                          @RequestParam String contentType) {
        Movie movie = new Movie(title, genre, releaseYear, duration, contentType);
        movieService.saveMovie(movie);
        return "redirect:/admin/movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "admin/edit-movie";
    }
    
    @PostMapping("/movies/edit/{id}")
    public String updateMovie(@PathVariable Long id, @RequestParam String title, 
                             @RequestParam String genre, @RequestParam Integer releaseYear,
                             @RequestParam Integer duration, @RequestParam String contentType,
                             @RequestParam(required = false) Float ratingAvg) {
        Movie movie = movieService.getMovieById(id);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setReleaseYear(releaseYear);
        movie.setDuration(duration);
        movie.setContentType(contentType);
        if (ratingAvg != null) {
            movie.setRatingAvg(ratingAvg);
        }
        movieService.saveMovie(movie);
        return "redirect:/admin/movies";
    }
    
    @PostMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/admin/movies";
    }
}