package com.example.Fitness.dto;

import com.example.Fitness.modal.ActivityType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {
  

    private String id;
    private String UserId;
    private ActivityType type;
    private Map<String,Object> additionalMetrics;
    private Integer duration;
    private  Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
