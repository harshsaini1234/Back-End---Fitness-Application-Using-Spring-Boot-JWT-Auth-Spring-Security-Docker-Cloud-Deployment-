package com.example.Fitness.service;

import com.example.Fitness.dto.RegisterRequest;
import com.example.Fitness.modal.User;
import com.example.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;      // or UserRepository userrepository
    public User register(RegisterRequest request) {
        User user = new User(
               null,
                request.getEmail(),
                request.getPassword(),
                request.getFirstName(),
                request.getLastName(),
                Instant.parse("2025-12-08T14:49:41.208Z")
                        .atZone(ZoneOffset.UTC)
                        .toLocalDateTime(),
                Instant.parse("2025-12-08T14:49:41.208Z")
                        .atZone(ZoneOffset.UTC)
                        .toLocalDateTime(),
                List.of(),
                List.of()
        );
        return userRepository.save(user);
    }
}
