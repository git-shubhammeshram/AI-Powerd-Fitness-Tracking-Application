package com.fitnesstracking.Service;

import com.fitnesstracking.DTO.ActivityRequest;
import com.fitnesstracking.DTO.ActivityResponse;
import com.fitnesstracking.Model.Activity;
import com.fitnesstracking.Repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServices {

    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    public ActivityResponse trackActivities(ActivityRequest request) {

        boolean validUser = userValidationService.isValidUser(request.getUserID());
        if(!validUser){
            throw new RuntimeException("Invalid User " + request.getUserID());
        }

        Activity activity = Activity.builder()
                .userID(request.getUserID())
                .type(request.getType())
                .duration(request.getDuration())
                .calories(request.getCalories())
                .startTime(request.getStartTime())
                .additionalInfo(request.getAdditionalInfo())
                .build();
        Activity savedActivity = activityRepository.save(activity);

        /*Publish to Rabbitmq for AI processing*/
        try{
            rabbitTemplate.convertAndSend(exchangeName,routingKey,savedActivity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to publish to RabbitMQ "+e);
        }
        return MapToResponse(savedActivity);

    }

    private ActivityResponse MapToResponse(Activity activity){
        ActivityResponse response = new ActivityResponse();
        response.setActivityID(activity.getActivityID());
        response.setUserID(activity.getUserID());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCalories(activity.getCalories());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalInfo(activity.getAdditionalInfo());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;

    }

    public List<ActivityResponse> getActivities(String userId) {
        List<Activity> activities = activityRepository.findByUserID(userId);
        return activities.stream()
                .map(this::MapToResponse)
                .collect(Collectors.toList());

    }

    public ActivityResponse getActivity(String activityID) {
        return activityRepository.findById(activityID)
                .map(this::MapToResponse)
                .orElseThrow(()-> new RuntimeException("Activity not found"));
    }
}
