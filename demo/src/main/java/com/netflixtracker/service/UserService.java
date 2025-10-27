package com.netflixtracker.service;

import com.netflixtracker.model.User;
import com.netflixtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public User registerUser(String name, String email, String password, String subscriptionType) {
        User user = new User(name, email, subscriptionType, password, "USER");
        return saveUser(user);
    }
    
    public boolean existsByEmail(String email) {
        return getUserByEmail(email) != null;
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}