package com.example.Fitness.controller;

import com.example.Fitness.modal.User;
import com.example.Fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final UserService userService;

    @PostMapping("/")
   public ResponseEntity<ActivityResponse> trackActivity(){
        return " ";
    }
    @GetMapping()
    public ResponseEntity<List<ActivityResponse>> trackActivity(){

    }

}
