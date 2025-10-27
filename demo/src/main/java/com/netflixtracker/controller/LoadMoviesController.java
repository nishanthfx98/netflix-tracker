package com.netflixtracker.controller;

import com.netflixtracker.model.Movie;
import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadMoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/load-movies")
    public String loadMovies() {
        try {
            // Recent Movies
            movieService.saveMovie(new Movie("Avengers: Endgame", "Action", 2019, 181, "Movie"));
            movieService.saveMovie(new Movie("Spider-Man: No Way Home", "Action", 2021, 148, "Movie"));
            movieService.saveMovie(new Movie("Top Gun: Maverick", "Action", 2022, 130, "Movie"));
            movieService.saveMovie(new Movie("Dune", "Sci-Fi", 2021, 155, "Movie"));
            movieService.saveMovie(new Movie("Interstellar", "Sci-Fi", 2014, 169, "Movie"));
            movieService.saveMovie(new Movie("Blade Runner 2049", "Sci-Fi", 2017, 164, "Movie"));
            movieService.saveMovie(new Movie("The Dark Knight", "Action", 2008, 152, "Movie"));
            
            // Recent Series
            movieService.saveMovie(new Movie("Stranger Things", "Sci-Fi", 2016, 50, "Series"));
            movieService.saveMovie(new Movie("The Witcher", "Fantasy", 2019, 60, "Series"));
            movieService.saveMovie(new Movie("Wednesday", "Horror", 2022, 45, "Series"));
            movieService.saveMovie(new Movie("House of the Dragon", "Fantasy", 2022, 55, "Series"));
            movieService.saveMovie(new Movie("Squid Game", "Thriller", 2021, 60, "Series"));
            movieService.saveMovie(new Movie("Money Heist", "Thriller", 2017, 70, "Series"));
            movieService.saveMovie(new Movie("Ozark", "Drama", 2017, 60, "Series"));
            movieService.saveMovie(new Movie("The Crown", "Drama", 2016, 58, "Series"));
            
            // Comedy Movies
            movieService.saveMovie(new Movie("Deadpool", "Comedy", 2016, 108, "Movie"));
            movieService.saveMovie(new Movie("The Grand Budapest Hotel", "Comedy", 2014, 99, "Movie"));
            movieService.saveMovie(new Movie("Knives Out", "Comedy", 2019, 130, "Movie"));
            
            // Horror Movies
            movieService.saveMovie(new Movie("Get Out", "Horror", 2017, 104, "Movie"));
            movieService.saveMovie(new Movie("A Quiet Place", "Horror", 2018, 90, "Movie"));
            movieService.saveMovie(new Movie("Hereditary", "Horror", 2018, 127, "Movie"));
            
            return "Successfully loaded " + movieService.getAllMovies().size() + " movies!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}