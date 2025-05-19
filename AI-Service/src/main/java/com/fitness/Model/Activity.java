package com.fitness.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class Activity {
    @Id
    private String id;
    private String userID;
    private String Type;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;
    private Map<String,Object> additionalInfo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
