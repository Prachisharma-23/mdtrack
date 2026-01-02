package com.example.moodtracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moodtracker.model.User;
import com.example.moodtracker.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://mood-tracker-psi-ecru.vercel.app/")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    // ✅ LOGIN (basic version)
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return userRepository.findByEmail(user.getEmail())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
