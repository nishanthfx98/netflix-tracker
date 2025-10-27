package com.netflixtracker.controller;

import com.netflixtracker.model.WatchHistory;
import com.netflixtracker.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class WatchHistoryController {
    
    @Autowired
    private WatchHistoryService watchHistoryService;
    
    @PostMapping
    public ResponseEntity<WatchHistory> addWatchHistory(@RequestBody WatchHistory watchHistory) {
        WatchHistory saved = watchHistoryService.saveWatchHistory(watchHistory);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<WatchHistory>> getWatchHistoryByUser(@PathVariable Long id) {
        List<WatchHistory> history = watchHistoryService.getWatchHistoryByUser(id);
        return ResponseEntity.ok(history);
    }
    
    @GetMapping("/movie/{id}")
    public ResponseEntity<List<WatchHistory>> getWatchHistoryByMovie(@PathVariable Long id) {
        List<WatchHistory> history = watchHistoryService.getWatchHistoryByMovie(id);
        return ResponseEntity.ok(history);
    }
    
    @GetMapping("/top-watched")
    public ResponseEntity<List<Object[]>> getTopWatchedMovies() {
        List<Object[]> topMovies = watchHistoryService.getTopWatchedMovies();
        return ResponseEntity.ok(topMovies);
    }
}