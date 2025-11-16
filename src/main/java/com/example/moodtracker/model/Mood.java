package com.example.moodtracker.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mood;    // Happy, Sad, Angry, etc.
    private String note;    // Optional note
    private LocalDateTime timestamp = LocalDateTime.now();
}
