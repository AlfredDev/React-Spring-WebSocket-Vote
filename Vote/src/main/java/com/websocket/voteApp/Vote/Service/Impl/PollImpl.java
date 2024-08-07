package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.Request.PollRequest;
import com.websocket.voteApp.Vote.DTO.Response.PollResponse;
import com.websocket.voteApp.Vote.Service.PollService;

import java.util.List;

public class PollImpl implements PollService {
    @Override
    public List<PollResponse> getAllPolls() {
        return null;
    }

    @Override
    public PollResponse getPollById(Long id) {
        return null;
    }

    @Override
    public PollResponse createPoll(PollRequest request) {
        return null;
    }

    @Override
    public PollResponse updatePoll(PollRequest request) {
        return null;
    }

    @Override
    public void deletePollById(Long id) {

    }
}
