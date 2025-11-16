package com.example.moodtracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moodtracker.dto.MoodRequest;
import com.example.moodtracker.model.Mood;
import com.example.moodtracker.service.MoodService;

@RestController
@RequestMapping("/api/moods")
@CrossOrigin(origins = "https://mood-tracker-psi-ecru.vercel.app")
public class MoodController {

    private final MoodService service;

    public MoodController(MoodService service) {
        this.service = service;
    }

    @PostMapping
    public Mood addMood(@RequestBody MoodRequest request) {
        return service.addMood(request);
    }

    @GetMapping
    public List<Mood> getAll() {
        return service.getAllMoods();
    }
}
