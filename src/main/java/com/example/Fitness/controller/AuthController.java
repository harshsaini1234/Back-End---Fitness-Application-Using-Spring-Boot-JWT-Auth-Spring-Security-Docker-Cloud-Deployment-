package com.example.Fitness.controller;

import com.example.Fitness.dto.RegisterRequest;
import com.example.Fitness.modal.User;
import com.example.Fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    //    UserService userService;

//    Can you use both or not

    private final UserService userService;



    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }
}
