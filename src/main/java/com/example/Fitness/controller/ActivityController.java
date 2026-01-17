package com.example.Fitness.controller;

import com.example.Fitness.dto.ActivityRequest;
import com.example.Fitness.dto.ActivityResponse;
import com.example.Fitness.modal.User;
import com.example.Fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final UserService userService;

    @PostMapping("/")
   public ResponseEntity<ActivityResponse> trackActivity(@RequestBody  ActivityRequest request){
        return " ";
    }
//    @GetMapping()
//    public ResponseEntity<List<ActivityResponse>> trackActivity(){
//     return " ";
//    }

}
