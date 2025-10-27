package com.netflixtracker;

import com.netflixtracker.model.Movie;
import com.netflixtracker.model.User;
// import com.netflixtracker.model.WatchHistory;
import com.netflixtracker.service.MovieService;
import com.netflixtracker.service.UserService;
// import com.netflixtracker.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// @Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MovieService movieService;
    
    @Autowired
    // private WatchHistoryService watchHistoryService;
    
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Create admin user if doesn't exist
        if (!userService.existsByEmail("admin@netflix.com")) {
            User admin = new User("Admin", "admin@netflix.com", "Premium", "admin123", "ADMIN");
            userService.saveUser(admin);
        }
        
        // Initialize movies if they don't exist
        if (movieService.getAllMovies().isEmpty()) {

            // Create sample movies and series
            Movie movie1 = new Movie("The Matrix", "Action", 1999, 136, "Movie");
            Movie movie2 = new Movie("Inception", "Sci-Fi", 2010, 148, "Movie");
            Movie movie3 = new Movie("Breaking Bad", "Drama", 2008, 45, "Series");
            
            // Recent Movies
            Movie movie4 = new Movie("Avengers: Endgame", "Action", 2019, 181, "Movie");
            Movie movie5 = new Movie("Spider-Man: No Way Home", "Action", 2021, 148, "Movie");
            Movie movie6 = new Movie("Top Gun: Maverick", "Action", 2022, 130, "Movie");
            Movie movie7 = new Movie("Dune", "Sci-Fi", 2021, 155, "Movie");
            Movie movie8 = new Movie("Interstellar", "Sci-Fi", 2014, 169, "Movie");
            Movie movie9 = new Movie("Blade Runner 2049", "Sci-Fi", 2017, 164, "Movie");
            Movie movie10 = new Movie("The Dark Knight", "Action", 2008, 152, "Movie");
            
            // Recent Series
            Movie series1 = new Movie("Stranger Things", "Sci-Fi", 2016, 50, "Series");
            Movie series2 = new Movie("The Witcher", "Fantasy", 2019, 60, "Series");
            Movie series3 = new Movie("Wednesday", "Horror", 2022, 45, "Series");
            Movie series4 = new Movie("House of the Dragon", "Fantasy", 2022, 55, "Series");
            Movie series5 = new Movie("Squid Game", "Thriller", 2021, 60, "Series");
            Movie series6 = new Movie("Money Heist", "Thriller", 2017, 70, "Series");
            Movie series7 = new Movie("Ozark", "Drama", 2017, 60, "Series");
            Movie series8 = new Movie("The Crown", "Drama", 2016, 58, "Series");
            
            // Comedy Movies
            Movie comedy1 = new Movie("Deadpool", "Comedy", 2016, 108, "Movie");
            Movie comedy2 = new Movie("The Grand Budapest Hotel", "Comedy", 2014, 99, "Movie");
            Movie comedy3 = new Movie("Knives Out", "Comedy", 2019, 130, "Movie");
            
            // Horror Movies
            Movie horror1 = new Movie("Get Out", "Horror", 2017, 104, "Movie");
            Movie horror2 = new Movie("A Quiet Place", "Horror", 2018, 90, "Movie");
            Movie horror3 = new Movie("Hereditary", "Horror", 2018, 127, "Movie");
            
            movieService.saveMovie(movie1);
            movieService.saveMovie(movie2);
            movieService.saveMovie(movie3);
            movieService.saveMovie(movie4);
            movieService.saveMovie(movie5);
            movieService.saveMovie(movie6);
            movieService.saveMovie(movie7);
            movieService.saveMovie(movie8);
            movieService.saveMovie(movie9);
            movieService.saveMovie(movie10);
            movieService.saveMovie(series1);
            movieService.saveMovie(series2);
            movieService.saveMovie(series3);
            movieService.saveMovie(series4);
            movieService.saveMovie(series5);
            movieService.saveMovie(series6);
            movieService.saveMovie(series7);
            movieService.saveMovie(series8);
            movieService.saveMovie(comedy1);
            movieService.saveMovie(comedy2);
            movieService.saveMovie(comedy3);
            movieService.saveMovie(horror1);
            movieService.saveMovie(horror2);
            movieService.saveMovie(horror3);
        }
    }
}