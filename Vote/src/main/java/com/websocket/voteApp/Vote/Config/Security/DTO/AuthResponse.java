package com.websocket.voteApp.Vote.Config.Security.DTO;

import com.websocket.voteApp.Vote.Models.User.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private ERole role;
}
