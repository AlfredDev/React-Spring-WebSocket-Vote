package com.websocket.voteApp.Vote.Service;

import com.websocket.voteApp.Vote.DTO.Request.PollRequest;
import com.websocket.voteApp.Vote.DTO.Response.PollResponse;

import java.util.List;

public interface PollService {
    List<PollResponse> getAllPolls();

    PollResponse getPollById(Long id);

    PollResponse createPoll(PollRequest request);

    PollResponse updatePoll(PollRequest request);

    void deletePollById(Long id);

}
