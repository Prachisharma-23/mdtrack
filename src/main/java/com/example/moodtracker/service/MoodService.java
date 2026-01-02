package com.example.moodtracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.moodtracker.dto.MoodRequest;
import com.example.moodtracker.model.Mood;
import com.example.moodtracker.model.User;
import com.example.moodtracker.repository.MoodRepository;
import com.example.moodtracker.repository.UserRepository;

@Service
public class MoodService {

    private final MoodRepository moodRepository;
    private final UserRepository userRepository;

    public MoodService(MoodRepository moodRepository, UserRepository userRepository) {
        this.moodRepository = moodRepository;
        this.userRepository = userRepository;
    }

    public Mood addMood(MoodRequest req) {

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Mood mood = new Mood();
        mood.setMood(req.getMood());
        mood.setNote(req.getNote());
        mood.setUser(user);   // 👈 LINK USER

        return moodRepository.save(mood);
    }

    public List<Mood> getMoodsByUser(Long userId) {
        return moodRepository.findByUserId(userId);
    }
}

