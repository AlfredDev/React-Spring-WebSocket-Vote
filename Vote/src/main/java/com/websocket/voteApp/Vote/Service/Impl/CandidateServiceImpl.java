package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.Request.CandidateRequest;
import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.Service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Override
    public List<CandidateResponse> getCandidates() {
        return null;
    }

    @Override
    public CandidateResponse getCandidateById(Long id) {
        return null;
    }

    @Override
    public CandidateResponse saveCandidate(CandidateRequest candidateRequest) {
        return null;
    }

    @Override
    public void deleteCandidateById(Long candidateId) {

    }
}
