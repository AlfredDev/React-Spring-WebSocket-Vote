package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate toCandidate(CandidateResponse candidateResponse);

    CandidateResponse toCandidateResponse(Candidate candidate);
}
