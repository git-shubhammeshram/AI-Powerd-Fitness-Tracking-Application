package com.fitnesstracking.Controller;

import com.fitnesstracking.DTO.ActivityRequest;
import com.fitnesstracking.DTO.ActivityResponse;
import com.fitnesstracking.Service.ActivityServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private final ActivityServices activityServices;
    @PostMapping()
    public ResponseEntity<ActivityResponse> trackActivities(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityServices.trackActivities(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getActivities(@RequestHeader("X-USER-ID") String userId){
        return ResponseEntity.ok(activityServices.getActivities(userId));
    }

    @GetMapping("/{activityID}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable String activityID){
        return ResponseEntity.ok(activityServices.getActivity(activityID));
    }



}
