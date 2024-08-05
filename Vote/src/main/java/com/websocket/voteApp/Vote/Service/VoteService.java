package com.websocket.voteApp.Vote.Service;

import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Vote;

import java.util.List;

public interface VoteService {
    VoteResponse saveVote(Long userId, Long candidateId, Long pollId);

    VoteResponse saveVote(Vote vote);

    List<VoteResponse> getAllVotes();

    List<VoteResponse> getVotesFromPoll();

}
