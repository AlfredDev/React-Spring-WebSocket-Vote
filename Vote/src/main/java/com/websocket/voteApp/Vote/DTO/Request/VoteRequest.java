package com.websocket.voteApp.Vote.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteRequest {
    @NotNull(message = "Its necessary to provide the candidate")
    private Long idCandidate;
    @NotNull(message = "Its necessary to provide the poll reference")
    private Long pollId;
}
