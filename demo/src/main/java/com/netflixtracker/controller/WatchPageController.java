package com.netflixtracker.controller;

import com.netflixtracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WatchPageController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/watch/{id}")
    public String watchPage(@PathVariable Long id, Model model) {
        var movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "watch";
    }
}