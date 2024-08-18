package com.websocket.voteApp.Vote.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CandidateRequest {

    @NotNull
    private Long idPoll;
    @NotBlank(message = "Candidate name can´t be empty")
    @Size(max = 100, message = "Name must be less than 6 characters")
    private String name;
    @NotBlank(message = "Party name can´t be empty")
    @Size(max = 100, message = "Party must be less than 6 characters")
    private String partyName;

}
