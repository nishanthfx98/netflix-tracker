package com.netflixtracker.controller;

import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddTrailersController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/add-trailers")
    public String addTrailers() {
        var movies = movieService.getAllMovies();
        
        for (var movie : movies) {
            switch (movie.getTitle()) {
                case "The Matrix":
                    movie.setTrailerUrl("https://www.youtube.com/embed/vKQi3bBA1y8");
                    break;
                case "Inception":
                    movie.setTrailerUrl("https://www.youtube.com/embed/YoHD9XEInc0");
                    break;
                case "Breaking Bad":
                    movie.setTrailerUrl("https://www.youtube.com/embed/HhesaQXLuRY");
                    break;
                case "Avengers: Endgame":
                    movie.setTrailerUrl("https://www.youtube.com/embed/TcMBFSGVi1c");
                    break;
                case "Spider-Man: No Way Home":
                    movie.setTrailerUrl("https://www.youtube.com/embed/JfVOs4VSpmA");
                    break;
                case "Dune":
                    movie.setTrailerUrl("https://www.youtube.com/embed/n9xhJrPXop4");
                    break;
                case "Stranger Things":
                    movie.setTrailerUrl("https://www.youtube.com/embed/b9EkMc79ZSU");
                    break;
                case "The Witcher":
                    movie.setTrailerUrl("https://www.youtube.com/embed/ndl1W4ltcmg");
                    break;
                case "Squid Game":
                    movie.setTrailerUrl("https://www.youtube.com/embed/oqxAJKy0ii4");
                    break;
                case "Wednesday":
                    movie.setTrailerUrl("https://www.youtube.com/embed/Di310WS8zLk");
                    break;
                default:
                    movie.setTrailerUrl("https://www.youtube.com/embed/dQw4w9WgXcQ"); // Default trailer
                    break;
            }
            movieService.saveMovie(movie);
        }
        
        return "Added trailers to " + movies.size() + " movies!";
    }
}