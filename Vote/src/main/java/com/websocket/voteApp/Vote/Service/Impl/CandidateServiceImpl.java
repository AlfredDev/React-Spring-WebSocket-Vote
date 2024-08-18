package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.Request.CandidateRequest;
import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.Exceptions.ResourceNotFoundException;
import com.websocket.voteApp.Vote.Mappers.CandidateMapper;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Models.Poll;
import com.websocket.voteApp.Vote.Repository.CandidateRepository;
import com.websocket.voteApp.Vote.Repository.PollRepository;
import com.websocket.voteApp.Vote.Service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    private final PollRepository pollRepository;

    @Override
    public List<CandidateResponse> getCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        if (candidates.isEmpty()) throw new ResourceNotFoundException("There aren´t Candidates");
        return candidates.stream().map(
                candidateMapper::toCandidateResponse
        ).toList();
    }

    @Override
    public CandidateResponse getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with id " + id + " not found"));
        return candidateMapper.toCandidateResponse(candidate);
    }

    @Override
    public CandidateResponse saveCandidate(CandidateRequest candidateRequest) {
        Poll pol = pollRepository.findById(candidateRequest.getIdPoll())
                .orElseThrow(() -> new ResourceNotFoundException("No poll found for id "));
        Candidate candidate = Candidate.builder()
                .name(candidateRequest.getName())
                .partyName(candidateRequest.getPartyName())
                .poll(pol)
                .build();
        return candidateMapper.toCandidateResponse(
                candidateRepository.save(candidate)
        );
    }

    @Override
    public void deleteCandidateById(Long candidateId) {
        candidateRepository.findById(candidateId).ifPresentOrElse(
                candidateRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Candidate with id " + candidateId + " not found");
                }
        );
    }

}
