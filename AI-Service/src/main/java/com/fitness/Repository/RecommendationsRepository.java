package com.fitness.Repository;

import com.fitness.Model.Recommendations;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RecommendationsRepository extends MongoRepository<Recommendations,String> {
    List<Recommendations> findByUserId(String userId);
    Optional<Recommendations> findByActivityId(String activityId);
}
