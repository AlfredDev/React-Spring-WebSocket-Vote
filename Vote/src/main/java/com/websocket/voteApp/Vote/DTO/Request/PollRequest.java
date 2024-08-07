package com.websocket.voteApp.Vote.DTO.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class PollRequest {
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

}
