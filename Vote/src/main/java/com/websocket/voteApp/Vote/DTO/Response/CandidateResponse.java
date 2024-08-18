package com.websocket.voteApp.Vote.DTO.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class CandidateResponse {
    private Long id;
    private String name;
    private String partyName;

    private Long pollId;
}