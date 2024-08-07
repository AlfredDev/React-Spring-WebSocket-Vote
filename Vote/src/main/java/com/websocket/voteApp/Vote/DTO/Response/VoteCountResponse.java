package com.websocket.voteApp.Vote.DTO.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VoteCountResponse {
    private Long candidateId;
    private String candidateName;
    private int voteCount;
}
