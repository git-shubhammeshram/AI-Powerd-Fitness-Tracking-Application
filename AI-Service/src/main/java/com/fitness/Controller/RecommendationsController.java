package com.fitness.Controller;

import com.fitness.Model.Recommendations;
import com.fitness.Service.RecommendationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendations>> getUserRecommendations(@PathVariable String userId){
        return ResponseEntity.ok(recommendationsService.getUserRecommendations(userId));
    }

    @GetMapping("activity/{activityId}")
    public ResponseEntity<Recommendations> getActivityRecommendations(@PathVariable String activityId){
        return ResponseEntity.ok(recommendationsService.getActivityRecommendations(activityId));
    }
 }
