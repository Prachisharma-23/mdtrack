package com.example.moodtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moodtracker.model.Mood;


public interface MoodRepository extends JpaRepository<Mood, Long> {
    List<Mood> findByUserId(Long userId);
 }
