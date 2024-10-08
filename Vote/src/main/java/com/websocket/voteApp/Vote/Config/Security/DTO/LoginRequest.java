package com.websocket.voteApp.Vote.Config.Security.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Please enter a valid email address")
    private String email;
    @NotBlank(message = "Please enter a valid password")
    @Size(min = 8, max = 20, message = "The password must be between 8 and 20 characters")
    private String password;

}
