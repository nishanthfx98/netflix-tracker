package com.netflixtracker.controller;

import com.netflixtracker.service.UserService;
import com.netflixtracker.service.WatchHistoryService;
import com.netflixtracker.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private WatchHistoryService watchHistoryService;
    
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email, 
                              @RequestParam String password, @RequestParam String subscriptionType) {
        userService.registerUser(name, email, password, subscriptionType);
        return "redirect:/login?registered";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    
    @GetMapping("/my-history")
    public String myHistory(Model model, Authentication auth) {
        String email = auth.getName();
        var user = userService.getUserByEmail(email);
        var history = watchHistoryService.getWatchHistoryByUser(user.getUserId());
        model.addAttribute("watchHistory", history);
        return "my-history";
    }
    
    @GetMapping("/recommendations")
    public String recommendations(Model model, Authentication auth) {
        String email = auth.getName();
        var user = userService.getUserByEmail(email);
        if (user != null) {
            var recommendations = recommendationService.getRecommendedMovies(user.getUserId());
            model.addAttribute("recommendations", recommendations);
        }
        return "recommendations";
    }
}