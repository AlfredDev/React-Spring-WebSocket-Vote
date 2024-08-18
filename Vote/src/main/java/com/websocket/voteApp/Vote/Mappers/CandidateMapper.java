package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate toCandidate(CandidateResponse candidateResponse);
    @Mapping(source = "poll.id", target = "pollId")
    @Mapping(source = "voteCount", target = "countVote")
    CandidateResponse toCandidateResponse(Candidate candidate);
}
