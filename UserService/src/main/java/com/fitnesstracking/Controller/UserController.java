package com.fitnesstracking.Controller;

import com.fitnesstracking.DTO.RegisterRequest;
import com.fitnesstracking.DTO.UserResponse;
import com.fitnesstracking.Service.UserServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserServices userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> getUserProfile(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userId){
        log.info("CALLING USER VALIDATION API FOR USERID:{}",userId);
        return ResponseEntity.ok(userService.exitByUserID(userId));
    }


}
