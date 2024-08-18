package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.Request.VoteRequest;
import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Exceptions.ResourceNotFoundException;
import com.websocket.voteApp.Vote.Mappers.VoteMapper;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Models.Poll;
import com.websocket.voteApp.Vote.Models.User.User;
import com.websocket.voteApp.Vote.Models.Vote;
import com.websocket.voteApp.Vote.Repository.CandidateRepository;
import com.websocket.voteApp.Vote.Repository.PollRepository;
import com.websocket.voteApp.Vote.Repository.UserRepository;
import com.websocket.voteApp.Vote.Repository.VoteRepository;
import com.websocket.voteApp.Vote.Service.VoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final VoteMapper voteMapper;
    private final UserRepository userRepository;
    private final PollRepository pollRepository;
    private final CandidateRepository candidateRepository;

    @Override
    @Transactional
    public VoteResponse saveVote(Long userId, VoteRequest request) {
        System.out.println(request.getPollId());

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

        Poll poll = pollRepository.findById(request.getPollId())
                .orElseThrow(() -> new ResourceNotFoundException("Poll with ID " + request.getPollId() + " not found"));

        Candidate candidate = candidateRepository.findById(request.getIdCandidate())
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with ID " + request.getIdCandidate() + " not found"));

        Vote vote = Vote.builder()
                .candidate(candidate)
                .user(user)
                .timestamp(LocalDateTime.now())
                .poll(poll)
                .build();
        return voteMapper.toVoteResponse(voteRepository.save(vote));
    }

    @Override
    public VoteResponse saveVote(Vote vote) {
        return null;
    }


    @Override
    public List<VoteResponse> getAllVotes() {
        List<Vote> votes = voteRepository.findAll();
        if (votes.isEmpty()) return Collections.emptyList();
        return votes.stream()
                .map(voteMapper::toVoteResponse)
                .toList();
    }

    @Override
    public Page<VoteResponse> getVotesFromPoll(Long pollId, Pageable pageable) {
        Page<Vote> votes = voteRepository.getVotesByPollId(pollId, pageable);
        if (votes.isEmpty()) throw new ResourceNotFoundException("No votes found for poll with ID " + pollId);

        return votes.map(voteMapper::toVoteResponse);
    }

    @Override
    public VoteResponse getVoteById(Long voteId) {
        Vote vote = voteRepository.findById(voteId)
                .orElseThrow(() -> new ResourceNotFoundException("Could found vote"));
        return voteMapper.toVoteResponse(vote);
    }

    @Override
    public List<Candidate> getAllCandidatesWithVotes() {
        return candidateRepository.findAll();
    }


}
