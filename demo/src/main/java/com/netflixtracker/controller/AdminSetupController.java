package com.netflixtracker.controller;

import com.netflixtracker.model.User;
import com.netflixtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminSetupController {

    @Autowired
    private UserService userService;

    @GetMapping("/setup-admin")
    public String setupAdmin() {
        try {
            // Delete existing admin if exists
            User existing = userService.getUserByEmail("admin@netflix.com");
            if (existing != null) {
                return "Admin already exists. Try login with: admin@netflix.com / admin123";
            }
            
            // Create new admin
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@netflix.com");
            admin.setSubscriptionType("Premium");
            admin.setPassword("admin123");
            admin.setRole("ADMIN");
            
            userService.saveUser(admin);
            
            return "Admin created successfully! Login with: admin@netflix.com / admin123";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}