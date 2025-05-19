package com.fitnesstracking.DTO;

import com.fitnesstracking.Enum.ActivityType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityResponse {

    private String activityID;
    private String userID;
    private ActivityType type;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;
    private Map<String,Object> additionalInfo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
