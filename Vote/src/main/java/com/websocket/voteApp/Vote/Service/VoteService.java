package com.websocket.voteApp.Vote.Service;

import com.websocket.voteApp.Vote.DTO.Request.VoteRequest;
import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Models.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoteService {
    VoteResponse saveVote(Long userId, VoteRequest request);

    VoteResponse saveVote(Vote vote);

    List<VoteResponse> getAllVotes();

    Page<VoteResponse> getVotesFromPoll(Long pollId, Pageable pageable);

    VoteResponse getVoteById(Long voteId);

    List<Candidate> getAllCandidatesWithVotes();

}
