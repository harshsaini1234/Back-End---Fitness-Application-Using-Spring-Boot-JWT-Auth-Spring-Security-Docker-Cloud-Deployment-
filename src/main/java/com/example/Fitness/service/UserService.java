package com.example.Fitness.service;

import com.example.Fitness.dto.LoginRequest;
import com.example.Fitness.dto.RegisterRequest;
import com.example.Fitness.dto.UserResponse;
import com.example.Fitness.modal.User;
import com.example.Fitness.modal.UserRole;
import com.example.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.spec.EncodedKeySpec;


@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
   // or UserRepository userrepository
    public UserResponse register(RegisterRequest request) {
        UserRole role = request.getRole() != null ? request.getRole(): UserRole.USER;

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())  // Here , we used builder pattern to
                                                    // remove sequence issue of response or database
                                                     // don't follow sequence in column structure
                .lastName(request.getLastName())   // we have to call method manually like it.
                                                   // if you did then that is pretend default value null value.
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
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

    public UserResponse mapToRespons(User savedUser) {
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

    public User authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null )
            throw new RuntimeException("Invalid Credentials");

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }
        return user;
    }
}
