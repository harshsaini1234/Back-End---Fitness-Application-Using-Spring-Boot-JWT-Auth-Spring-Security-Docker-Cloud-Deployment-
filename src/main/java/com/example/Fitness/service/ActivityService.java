package com.example.Fitness.service;

import com.example.Fitness.dto.ActivityRequest;
import com.example.Fitness.dto.ActivityResponse;
import com.example.Fitness.modal.Activity;
import com.example.Fitness.modal.User;
import com.example.Fitness.repository.ActivityRepository;
import com.example.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("Invalid User: "+ request.getUserId()));
        Activity activity = Activity.builder()
                .user(user)

                .type(request.getType())
                .duration((request.getDuration()))
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();
        Activity savedActivity =  activityRepository.save(activity);
        return mapToResponse(savedActivity);

    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return  response;
    }
}
