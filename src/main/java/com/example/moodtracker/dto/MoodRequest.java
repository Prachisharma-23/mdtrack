package com.example.moodtracker.dto;

import lombok.Data;

@Data
public class MoodRequest {
    private String mood;
    private String note;
    private Long userId;
    
}
