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
    Long id;
    String name;
    String partyName;
}