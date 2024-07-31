package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Vote;
import com.websocket.voteApp.Vote.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    @Override
    public VoteResponse saveVote(Vote vote) {
        return null;
    }

    @Override
    public List<VoteResponse> getAllVotes() {
        return null;
    }

    @Override
    public List<VoteResponse> getVotesFromPoll() {
        return null;
    }
}
