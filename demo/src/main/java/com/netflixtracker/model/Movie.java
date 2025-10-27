package com.netflixtracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    
    @Column(nullable = false, length = 100)
    private String title;
    
    @Column(length = 50)
    private String genre;
    
    @Column(name = "release_year")
    private Integer releaseYear;
    
    private Integer duration;
    
    @Column(name = "rating_avg")
    private Float ratingAvg = 0.0f;
    
    @Column(name = "content_type", length = 30)
    private String contentType;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "trailer_url")
    private String trailerUrl;

    public Movie() {}

    public Movie(String title, String genre, Integer releaseYear, Integer duration, String contentType) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.contentType = contentType;
        this.imageUrl = "/assets/" + title + ".jpg";
    }

    // Getters and Setters
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    
    public Float getRatingAvg() { return ratingAvg; }
    public void setRatingAvg(Float ratingAvg) { this.ratingAvg = ratingAvg; }
    
    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public String getTrailerUrl() { return trailerUrl; }
    public void setTrailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; }
}