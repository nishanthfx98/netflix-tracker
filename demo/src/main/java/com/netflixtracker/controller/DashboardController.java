package com.netflixtracker.controller;

import com.netflixtracker.service.MovieService;
import com.netflixtracker.service.UserService;
import com.netflixtracker.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MovieService movieService;
    
    @Autowired
    private WatchHistoryService watchHistoryService;
    

}