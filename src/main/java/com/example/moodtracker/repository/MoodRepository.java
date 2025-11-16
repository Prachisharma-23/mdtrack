package com.example.moodtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moodtracker.model.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long> { }
