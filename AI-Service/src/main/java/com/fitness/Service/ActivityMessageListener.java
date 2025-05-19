package com.fitness.Service;

import com.fitness.Model.Activity;
import com.fitness.Repository.RecommendationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

    private final ActivityAIService aiService;
    private final RecommendationsRepository recommendationsRepository;

    @RabbitListener(queues = "activity.queue")
    public void processActivityMessage(Activity activity) {
        log.info("Recorded Activity for processing : {} ",activity.getId());
        log.info("Generated Recommendation for Activity : {} ",aiService.generateRecommendations(activity));
        /*Processing recommendations store into a mongodb database*/
        recommendationsRepository.save(aiService.generateRecommendations(activity));
    }
}
