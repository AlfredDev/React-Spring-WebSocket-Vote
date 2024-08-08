package com.websocket.voteApp.Vote.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class PollRequest {

    @NotEmpty(message = "The name of the poll can´t be empty")
    @Size(max = 100, message = "Name must be less than 6 characters")
    private String name;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;
    @NotNull(message = "End date cannot be null")
    private LocalDate endDate;

}
