package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.Request.PollRequest;
import com.websocket.voteApp.Vote.DTO.Response.PollResponse;
import com.websocket.voteApp.Vote.Models.Poll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface PollMapper {
    @Mapping(target = "voteCountPoll", source = "voteCount")
    PollResponse toPollResponse(Poll poll, int voteCount);

    Poll toPoll(PollRequest pollRequest);
}
