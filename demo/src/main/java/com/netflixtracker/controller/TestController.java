package com.netflixtracker.controller;

import com.netflixtracker.model.User;
import com.netflixtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/test-admin")
    public String testAdmin() {
        User admin = userService.getUserByEmail("admin@netflix.com");
        if (admin == null) {
            return "Admin user not found";
        }
        
        String rawPassword = "admin123";
        boolean matches = passwordEncoder.matches(rawPassword, admin.getPassword());
        
        return "Admin found: " + admin.getName() + 
               ", Role: " + admin.getRole() + 
               ", Password matches: " + matches +
               ", Stored password: " + admin.getPassword();
    }
}