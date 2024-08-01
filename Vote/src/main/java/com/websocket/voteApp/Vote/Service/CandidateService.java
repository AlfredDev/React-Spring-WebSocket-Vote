package com.websocket.voteApp.Vote.Service;

import com.websocket.voteApp.Vote.DTO.Request.CandidateRequest;
import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;

import java.util.List;

public interface CandidateService {
    List<CandidateResponse> getCandidates();

    CandidateResponse getCandidateById(Long id);

    CandidateResponse saveCandidate(CandidateRequest candidateRequest);

    void deleteCandidateById(Long candidateId);

}
