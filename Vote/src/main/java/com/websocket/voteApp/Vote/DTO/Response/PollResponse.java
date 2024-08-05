package com.websocket.voteApp.Vote.DTO.Response;

import com.websocket.voteApp.Vote.Models.Candidate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Getter
@Setter
public class PollResponse {
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;


}
