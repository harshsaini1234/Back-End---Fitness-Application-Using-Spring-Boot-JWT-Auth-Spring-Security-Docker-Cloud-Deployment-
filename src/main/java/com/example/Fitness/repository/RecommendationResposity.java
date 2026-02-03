package com.example.Fitness.repository;

import com.example.Fitness.modal.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationResposity extends JpaRepository<Recommendation,String> {
    List<Recommendation> findByUserId(String userId);

    List<Recommendation> findByActivityId(String activityId);
}
