package com.fitnesstracking.DTO;

import com.fitnesstracking.Enum.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequest {

    private String userID;
    private ActivityType type;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;
    private Map<String,Object> additionalInfo;
}
