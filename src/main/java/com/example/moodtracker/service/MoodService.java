package com.example.moodtracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.moodtracker.dto.MoodRequest;
import com.example.moodtracker.model.Mood;
import com.example.moodtracker.repository.MoodRepository;

@Service
public class MoodService {

    private final MoodRepository repository;

    public MoodService(MoodRepository repository) {
        this.repository = repository;
    }

    public Mood addMood(MoodRequest req) {
        Mood mood = new Mood();
        mood.setMood(req.getMood());
        mood.setNote(req.getNote());
        return repository.save(mood);
    }

    public List<Mood> getAllMoods() {
        return repository.findAll();
    }
}
