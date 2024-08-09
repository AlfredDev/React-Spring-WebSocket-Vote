package com.websocket.voteApp.Vote.Utils;

import com.websocket.voteApp.Vote.Config.Security.JWT.JwtService;
import com.websocket.voteApp.Vote.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class Utils {
    private final JwtService jwtService;

    public String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    public Long getCurrentUserId(String token) {
        if (token == null || token.isEmpty()) throw new ResourceNotFoundException("Token Invalid");
        return jwtService.getIdFromToken(token);
    }
}
