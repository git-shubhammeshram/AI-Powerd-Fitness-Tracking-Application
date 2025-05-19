package com.fitnesstracking.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {
    private final WebClient  webClient;

    public boolean isValidUser(String userId) {
        log.info("CALLING USER VALIDATION API FOR USERID:{}",userId);
       try {
           return webClient.get()
                   .uri("api/users/{userId}/validate", userId)
                   .retrieve()
                   .bodyToMono(Boolean.class)
                   .block();
       }
       catch (WebClientResponseException e) {
           if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
               throw new RuntimeException("User Not Found "+userId);
           }
           else if (e.getStatusCode() == HttpStatus.BAD_REQUEST){
               throw new RuntimeException("Bad Request "+userId);
           }
       }
       return false;
    }
}
