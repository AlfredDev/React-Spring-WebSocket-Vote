package com.websocket.voteApp.Vote.Config.Security.Controllers;

import com.websocket.voteApp.Vote.Config.Security.DTO.AuthResponse;
import com.websocket.voteApp.Vote.Config.Security.DTO.LoginRequest;
import com.websocket.voteApp.Vote.Config.Security.DTO.RegisterRequest;
import com.websocket.voteApp.Vote.Config.Security.Services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    // =====================================================================
    //                              REGISTER
    // =====================================================================

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
