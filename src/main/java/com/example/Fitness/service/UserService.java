package com.example.Fitness.service;

import com.example.Fitness.dto.RegisterRequest;
import com.example.Fitness.dto.UserResponse;
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
    public UserResponse register(RegisterRequest request) {

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())  // Here , we used builder pattern to
                                                    // remove sequence issue of response or database
                                                     // don't follow sequence in column structure
                .lastName(request.getLastName())   // we have to call method manually like it.
                                                   // if you did then that is pretend default value null value.
                .password(request.getPassword())
                .build();

//        User user = new User(
//               null,
//                request.getEmail(),
//                request.getPassword(),
//                request.getFirstName(),
//                request.getLastName(),
//                Instant.parse("2025-12-08T14:49:41.208Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2025-12-08T14:49:41.208Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                List.of(),
//                List.of()
//        );
        User savedUser= userRepository.save(user);
        return mapToRespons(savedUser);
    }

    private UserResponse mapToRespons(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());

        return response;
    }
}
