package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface VoteMapper {
    Vote toVote(VoteResponse voteResponse);

    @Mapping(source = "poll.name", target = "pollName")
    @Mapping(source = "candidate.name", target = "candidateName")
    @Mapping(source = "candidate.partyName", target = "candidatePartyName")
    VoteResponse toVoteResponse(Vote vote);}
