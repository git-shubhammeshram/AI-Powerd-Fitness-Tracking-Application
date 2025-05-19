package com.fitnesstracking.Model;


import com.fitnesstracking.Enum.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document(collection = "activities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    private String activityID;
    private String userID;
    private ActivityType type;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;

    @Field("metrics")
    private Map<String,Object> additionalInfo;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
