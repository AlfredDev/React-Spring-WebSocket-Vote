package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.Request.CandidateRequest;
import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.Exceptions.ResourceNotFoundException;
import com.websocket.voteApp.Vote.Mappers.CandidateMapper;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Repository.CandidateRepository;
import com.websocket.voteApp.Vote.Service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    @Override
    public List<CandidateResponse> getCandidates() {
        return null;
    }

    @Override
    public CandidateResponse getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with id " + id + " not found"));
        return candidateMapper.toCandidateResponse(candidate);
    }

    @Override
    public CandidateResponse saveCandidate(CandidateRequest candidateRequest) {
        return null;
    }

    @Override
    public void deleteCandidateById(Long candidateId) {

    }
}
