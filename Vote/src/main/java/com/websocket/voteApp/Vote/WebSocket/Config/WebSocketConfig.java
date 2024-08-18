package com.websocket.voteApp.Vote.WebSocket.Config;

import com.websocket.voteApp.Vote.Service.VoteService;
import com.websocket.voteApp.Vote.WebSocket.SocketHandler.VotingWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new VotingWebSocketHandler(), "/ws/voting")
                .setAllowedOrigins("*");
    }

}
