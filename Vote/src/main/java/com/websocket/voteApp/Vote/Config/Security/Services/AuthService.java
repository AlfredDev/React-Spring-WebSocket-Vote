package com.websocket.voteApp.Vote.Config.Security.Services;

import com.websocket.voteApp.Vote.Config.Security.DTO.AuthResponse;
import com.websocket.voteApp.Vote.Config.Security.DTO.LoginRequest;
import com.websocket.voteApp.Vote.Config.Security.DTO.RegisterRequest;
import com.websocket.voteApp.Vote.Config.Security.JWT.JwtService;
import com.websocket.voteApp.Vote.Exceptions.ResourceAlreadyExistException;
import com.websocket.voteApp.Vote.Models.User.ERole;
import com.websocket.voteApp.Vote.Models.User.User;
import com.websocket.voteApp.Vote.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user, user.getAuthorities());
        return AuthResponse.builder()
                .token(token)
                .email(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new ResourceAlreadyExistException("Email already exists.");

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .role(ERole.valueOf(request.getRole()))
                .build();
        userRepository.save(user);

        String token = jwtService.getToken(user, user.getAuthorities());

        return AuthResponse.builder()
                .token(token)
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }
}
