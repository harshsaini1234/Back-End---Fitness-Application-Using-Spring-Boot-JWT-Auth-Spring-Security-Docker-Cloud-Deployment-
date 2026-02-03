package com.example.Fitness.service;

import com.example.Fitness.dto.RecommendationRequest;
import com.example.Fitness.modal.Activity;
import com.example.Fitness.modal.Recommendation;
import com.example.Fitness.modal.User;
import com.example.Fitness.repository.ActivityRepository;
import com.example.Fitness.repository.RecommendationResposity;
import com.example.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationResposity recommendationResposity;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not Found " +request.getUserId()));

        Activity activity= activityRepository.findById(request.getActivityId())
                .orElseThrow(()-> new RuntimeException("Activity Not Found "+request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvement(request.getImprovement())
                .suggestion(request.getSuggestion())
                .safety(request.getSafety())
                .build();

        return recommendationResposity.save(recommendation);
    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationResposity.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationResposity.findByActivityId(activityId);    }
}
