package com.websocket.voteApp.Vote.DTO.Response;

import com.websocket.voteApp.Vote.Models.Candidate;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PollResponse {
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    private Integer voteCountPoll;
    private Set<CandidateResponse> candidates;

}
