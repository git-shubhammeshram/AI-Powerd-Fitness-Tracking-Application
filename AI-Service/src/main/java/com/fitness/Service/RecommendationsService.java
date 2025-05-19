package com.fitness.Service;

import com.fitness.Model.Recommendations;
import com.fitness.Repository.RecommendationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationsService {
    private final RecommendationsRepository recommendationsRepository;
    public List<Recommendations> getUserRecommendations(String userId) {
        return recommendationsRepository.findByUserId(userId);
    }

    public Recommendations getActivityRecommendations(String activityId) {
        return recommendationsRepository.findByActivityId(activityId)
                .orElseThrow(()-> new RuntimeException("Recommendation not found"));
    }
}
