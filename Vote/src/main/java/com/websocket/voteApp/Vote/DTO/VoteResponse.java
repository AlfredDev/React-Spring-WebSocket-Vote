package com.websocket.voteApp.Vote.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteResponse {
    Long id;
    String pollName;
    String candidateName;
    String candidatePartyName;
    LocalDateTime timestamp;
}