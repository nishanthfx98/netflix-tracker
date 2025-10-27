package com.netflixtracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "watch_history")
public class WatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @Column(name = "watch_date")
    private LocalDateTime watchDate = LocalDateTime.now();
    
    @Column(nullable = false)
    private Integer rating;

    public WatchHistory() {}

    public WatchHistory(User user, Movie movie, Integer rating) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getWatchId() { return watchId; }
    public void setWatchId(Long watchId) { this.watchId = watchId; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    
    public LocalDateTime getWatchDate() { return watchDate; }
    public void setWatchDate(LocalDateTime watchDate) { this.watchDate = watchDate; }
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
}