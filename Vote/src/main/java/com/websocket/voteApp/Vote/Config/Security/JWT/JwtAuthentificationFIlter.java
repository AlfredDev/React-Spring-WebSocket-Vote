package com.websocket.voteApp.Vote.Config.Security.JWT;

import com.websocket.voteApp.Vote.Config.Security.DTO.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;

@Component
@RequiredArgsConstructor
public class JwtAuthentificationFIlter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String token = getTokenFromRequest(request);
        final String username;
        // Token is null, continue the filter chain without any additional actions
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            username = jwtService.getUsernameFromToken(token);
            System.out.println("Username from token: " + username); // Registro de depuración
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtService.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            }

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            // Token expirado
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .dateTime(LocalDateTime.now())
                    .message("JWT expired")
                    .build();

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"" + errorResponse.getMessage() + "\", \"dateTime\": \"" + errorResponse.getDateTime() + "\", \"status\": " + HttpStatus.UNAUTHORIZED.value() + ", \"error\": \"Unauthorized\"}");
        }

    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }
}
