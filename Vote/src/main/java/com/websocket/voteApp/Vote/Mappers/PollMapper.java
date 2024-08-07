package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.Models.Poll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PollMapper {
    Poll toPollResponse(Poll poll);
}
