package com.example.Fitness.controller;

import com.example.Fitness.dto.ActivityRequest;
import com.example.Fitness.dto.ActivityResponse;
import com.example.Fitness.modal.User;
import com.example.Fitness.service.ActivityService;
import com.example.Fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
   public ResponseEntity<ActivityResponse> trackActivity(@RequestBody  ActivityRequest request){
        System.out.println(request.getUserId());
        System.out.println("------------------------------------------------------------");

        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivity(@RequestHeader(value = "X-User-ID") String userId){

     return ResponseEntity.ok(activityService.getUserActivities(userId));
    }

}
