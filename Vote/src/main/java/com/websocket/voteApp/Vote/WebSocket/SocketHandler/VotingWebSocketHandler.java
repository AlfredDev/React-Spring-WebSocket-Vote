package com.websocket.voteApp.Vote.WebSocket.SocketHandler;

import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class VotingWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private VoteService voteService;
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        session.sendMessage(new TextMessage("Received " + payload));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        session.sendMessage(new TextMessage("Connection established"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

    public void broadcastVoteUpdate() {
        List<Candidate> candidates = voteService.getAllCandidatesWithVotes();
        String updateMessage = createVoteUpdateMessage(candidates);

        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(updateMessage));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String createVoteUpdateMessage(List<Candidate> candidates) {
        StringBuilder messageBuilder = new StringBuilder("Vote Counts:");
        for (Candidate candidate : candidates) {
            messageBuilder.append("\n").append(candidate.getName()).append(": ")
                    .append(candidate.getVotes().size());
        }
        return messageBuilder.toString();
    }

}
