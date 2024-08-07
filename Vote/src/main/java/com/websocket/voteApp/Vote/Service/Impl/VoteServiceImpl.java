package com.websocket.voteApp.Vote.Service.Impl;

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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public VoteResponse saveVote(Long userId, Long candidateId, Long pollId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Doesn't Exist"));
        Poll poll = pollRepository.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("User doesnt Exist"));
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate Doesn´t Exisst"));
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
        if (votes.isEmpty()) throw new ResourceNotFoundException("There aren´t Candidates");
        return votes.stream().map(voteMapper::toVoteResponse)
                .toList();
    }

    @Override
    public List<VoteResponse> getVotesFromPoll() {
        return null;
    }

    @Override
    public VoteResponse getVoiteByYd(Long voteId) {
        Vote vote = voteRepository.findById(voteId).orElseThrow(() -> new ResourceNotFoundException("Could found vote"));
        return voteMapper.toVoteResponse(vote);
    }
}
