package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Vote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface VoteMapper {
    Vote toVote(VoteResponse voteResponse);

    VoteResponse toVoteResponse(Vote response);
}
