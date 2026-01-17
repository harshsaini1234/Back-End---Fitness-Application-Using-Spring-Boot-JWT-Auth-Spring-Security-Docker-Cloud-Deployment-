package com.example.Fitness.dto;

import com.example.Fitness.modal.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {


    private String UserId;
    private ActivityType type;
    private Map<String,Object> additionalMetrics;
    private Integer duration;
    private  Integer caloriesBurned;
    private LocalDateTime startTime;

}
