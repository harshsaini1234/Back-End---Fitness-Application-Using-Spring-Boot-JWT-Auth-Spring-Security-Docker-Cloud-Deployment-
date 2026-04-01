package com.example.Fitness.controller;

import com.example.Fitness.dto.LoginRequest;
import com.example.Fitness.dto.LoginResponse;
import com.example.Fitness.dto.RegisterRequest;
import com.example.Fitness.dto.UserResponse;
import com.example.Fitness.modal.User;
import com.example.Fitness.repository.UserRepository;
import com.example.Fitness.security.JwtUtils;
import com.example.Fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils  jwtUtils;



    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest ){
        try{
            User user = userService.authenticate(loginRequest);
            String toke = jwtUtils.generateToken(user.getId(),user.getRole().name());
            return ResponseEntity.ok(new LoginResponse(
                   toke,userService.mapToRespons(user)
           ));


        }catch (AuthenticationException e){
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }


    }
}
